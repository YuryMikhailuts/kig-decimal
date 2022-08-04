package mikhaylutsyury.kigdecimal

import mikhaylutsyury.kigdecimal.BigDecimalFormat.Companion.DEFAULT_FORMAT


/**
 * Интерфейс формата [BigDecimal].
 * Описывает структуру текстового представления длинного действительного числа и позволяет отображать число в строку в соответствии с форматом.
 */
interface BigDecimalFormat {
	fun format(value: BigDecimal): String

	companion object {
		val DEFAULT_FORMAT = PlainBigDecimalFormat(UInt.MAX_VALUE, UInt.MAX_VALUE) { "Число $it слишком большое" }
	}
}

fun BigDecimal.toString(format: BigDecimalFormat = DEFAULT_FORMAT) = format.format(this)
