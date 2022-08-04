package mikhaylutsyury.kigdecimal

/**
 * Описывает простой плоский формат текстового представления действительного числа.
 *
 * Формат: `«(?<sign>-)?(?<int>\d+).(?<fraction>\d+)»`.
 *
 *
 * @param integersCount Количество символов в целой части.
 * @param fractionsCount Количество символов в дробной части.
 * @param addZeroLeft Добавлять нули слева до ожидаемой длинны.
 * @param addZeroRight Добавлять нули справа до ожидаемой длинны.
 * @param decimalDot Строка, которая будет служить в роли десятичной точки.
 * @param signToStr Функция, генерирующая символ, показывающий знак числа.
 * @param overflowErrorMessage Функция, генерирующая сообщение об ошибке переполнения.
 * Данная ошибка будет брошена в случае, если количество цифр в целой части будет превышать ожидаемое.
 * В случае, если сообщение не задано, ошибка будет игнорироваться и число будет молча обрезаться до нужной длинны.
 */
open class PlainBigDecimalFormat(
	val integersCount: UInt,
	val fractionsCount: UInt,
	val addZeroLeft: Boolean = false,
	val addZeroRight: Boolean = false,
	val decimalDot: String = ".",
	val signToStr: (Int) -> String = { if (it < 0) "-" else "" },
	val overflowErrorMessage: BigDecimalToStringFunction? = null,
) : BigDecimalFormat {
	override fun format(value: BigDecimal): String {
		var result = ""
		val int = value.toBigInteger()
		val fraction = value.subtract(int.toBigDecimal())
		var tmp = fraction.abs()
		var fractionStr = ""
		var count = 0U
		while (true) {
			tmp = tmp.multiply(10.toBigDecimal())
			if (tmp.eq(0.toBigDecimal()) && !addZeroRight) break
			val tmpInt = tmp.toBigInteger()
			fractionStr += "$tmpInt"
			count++
			if (count >= fractionsCount) break
			tmp = tmp.subtract(tmpInt.toBigDecimal())
		}
		var intStr = "${int.abs()}"
		val leftZeroDiff = integersCount.toInt() - intStr.length
		if (leftZeroDiff > 0 && addZeroLeft) intStr = "0".repeat(leftZeroDiff) + intStr
		overflowErrorMessage?.also { msg -> require(leftZeroDiff < 0) { msg(value) } }
		val signStr = signToStr(value.signum())
		result = "$signStr$intStr$decimalDot$fractionStr"
		return result
	}
}