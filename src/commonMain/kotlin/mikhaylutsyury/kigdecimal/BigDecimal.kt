package mikhaylutsyury.kigdecimal

import mikhaylutsyury.kigdecimal.ext.BigDecimal

expect class BigDecimal {
	fun abs(): BigDecimal
	fun compareTo(other: BigDecimal): Int
	fun add(augend: BigDecimal): BigDecimal
	fun subtract(subtrahend: BigDecimal): BigDecimal
	fun multiply(multiplicand: BigDecimal): BigDecimal
	fun divide(divisor: BigDecimal): BigDecimal
	fun divide(other: BigDecimal, context: MathContext): BigDecimal
	fun divideToIntegralValue(divisor: BigDecimal): BigDecimal
	fun remainder(divisor: BigDecimal): BigDecimal
	fun divideAndRemainder(divisor: BigDecimal): Array<BigDecimal>
	fun pow(n: Int): BigDecimal
	fun negate(): BigDecimal
	fun plus(): BigDecimal
	fun signum(): Int
	fun scale(): Int
	fun precision(): Int
	fun unscaledValue(): BigInteger
	fun setScale(newScale: Int): BigDecimal
	fun movePointLeft(n: Int): BigDecimal
	fun movePointRight(n: Int): BigDecimal
	fun scaleByPowerOfTen(n: Int): BigDecimal
	fun stripTrailingZeros(): BigDecimal
	fun min(other: BigDecimal): BigDecimal
	fun max(other: BigDecimal): BigDecimal
	override fun hashCode(): Int
	fun toEngineeringString(): String
	fun toPlainString(): String
	fun toBigInteger(): BigInteger
	fun toBigIntegerExact(): BigInteger
	fun longValueExact(): Long
	fun intValueExact(): Int
	fun shortValueExact(): Short
	fun byteValueExact(): Byte
	fun ulp(): BigDecimal
}

infix fun BigDecimal.eq(other: BigDecimal) = compareTo(other) == 0


expect fun makeBigDecimal(text: String): BigDecimal
expect fun makeBigDecimal(value: Int): BigDecimal
expect fun makeBigDecimal(value: Long): BigDecimal
expect fun makeBigDecimal(value: Float): BigDecimal
expect fun makeBigDecimal(value: Double): BigDecimal


fun Int.toBigDecimal() = BigDecimal(this)
fun Long.toBigDecimal() = BigDecimal(this)
fun Float.toBigDecimal() = BigDecimal(this)
fun Double.toBigDecimal() = BigDecimal(this)
