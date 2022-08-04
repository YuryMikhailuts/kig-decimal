package bigdecimal

import mikhaylutsyury.kigdecimal.RoundingModes

external interface BigDecimalModule {
	fun BigInteger(text: String, radix: Int): BigInteger
	fun BigDecimal(text: String): BigDecimal
	fun BigDecimal(value: Int): BigDecimal
	fun BigDecimal(value: Float): BigDecimal
	fun BigDecimal(value: Double): BigDecimal

	val MathContext: MathContextStatic
	val RoundingMode: RoundingModeStatic
}

val DECIMAL128 get() = bigdecimal.MathContext.DECIMAL128()
val DECIMAL64 get() = bigdecimal.MathContext.DECIMAL64()
val DECIMAL32 get() = bigdecimal.MathContext.DECIMAL32()
val UNLIMITED get() = bigdecimal.MathContext.UNLIMITED()

val UP get() = bigdecimal.RoundingMode.UP()
val DOWN get() = bigdecimal.RoundingMode.DOWN()
val CEILING get() = bigdecimal.RoundingMode.CEILING()
val FLOOR get() = bigdecimal.RoundingMode.FLOOR()
val HALF_UP get() = bigdecimal.RoundingMode.HALF_UP()
val HALF_DOWN get() = bigdecimal.RoundingMode.HALF_DOWN()
val HALF_EVEN get() = bigdecimal.RoundingMode.HALF_EVEN()
val UNNECESSARY get() = bigdecimal.RoundingMode.UNNECESSARY()

@Suppress("SpellCheckingInspection")
val bigdecimal: BigDecimalModule by lazy { js("require(\"bigdecimal\")").unsafeCast<BigDecimalModule>() }

fun BigInteger(text: String, notation: Int = 10) = bigdecimal.BigInteger(text, notation)

fun BigInteger(value: Int) = BigInteger("$value")

fun Int.toBigInteger() = BigInteger(this)

fun BigInteger(value: Long) = BigInteger("$value")

fun Long.toBigInteger() = BigInteger(this)

fun BigDecimal(text: String) = bigdecimal.BigDecimal(text)

fun BigDecimal(value: Int) = bigdecimal.BigDecimal(value)

fun Int.toBigDecimal() = BigDecimal(this)

fun BigDecimal(value: Long) = BigDecimal("$value")
fun BigDecimal(value: BigInteger) = BigDecimal("$value")

fun Long.toBigDecimal() = BigDecimal(this)

fun BigDecimal(value: Float) = bigdecimal.BigDecimal(value)

fun Float.toBigDecimal() = BigDecimal(this)

fun BigDecimal(value: Double) = bigdecimal.BigDecimal(value)

fun Double.toBigDecimal() = BigDecimal(this)


@JsModule("bigdecimal")
@JsNonModule
@JsName("BigInteger")
external class BigInteger {
	fun abs(): BigInteger
	fun add(other: BigInteger): BigInteger
	fun and(other: BigInteger): BigInteger
	fun andNot(other: BigInteger): BigInteger
	fun bitCount(): Int
	fun bitLength(): Int
	fun compareTo(other: BigInteger): Int
	fun divide(other: BigInteger): BigInteger
	fun divideAndRemainder(other: BigInteger): Array<BigInteger>
	fun doubleValue(): Double
	fun flipBit(n: Int): BigInteger
	fun floatValue(): Float
	override fun hashCode(): Int
	fun intValue(): Int
	fun max(other: BigInteger): BigInteger
	fun min(other: BigInteger): BigInteger
	fun mod(other: BigInteger): BigInteger
	fun multiply(other: BigInteger): BigInteger
	fun negate(): BigInteger
	fun nextProbablePrime(): BigInteger
	fun not(): BigInteger
	fun or(other: BigInteger): BigInteger
	fun pow(exponent: Int): BigInteger
	fun remainder(other: BigInteger): BigInteger
	fun shiftLeft(n: Int): BigInteger
	fun shiftRight(n: Int): BigInteger
	fun signum(): Int
	fun subtract(other: BigInteger): BigInteger
	fun testBit(n: Int): Boolean
	fun xor(other: BigInteger): BigInteger
}

infix fun BigInteger.eq(other: BigInteger): Boolean = compareTo(other) == 0

@JsModule("bigdecimal")
@JsNonModule
@JsName("BigDecimal")
external class BigDecimal {
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
	fun setScale(newScale: Int, roundingMode: RoundingMode): BigDecimal
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
	fun intValue(): Int
	fun intValueExact(): Int
	fun shortValueExact(): Short
	fun byteValueExact(): Byte
	fun floatValue(): Float
	fun doubleValue(): Double
	fun ulp(): BigDecimal
	fun longDigitLength(x: Long): Int
	fun scaledTenPow(n: Int, sign: Int, scale: Int): BigDecimal
}

infix fun BigDecimal.eq(other: BigDecimal): Boolean = compareTo(other) == 0


@JsModule("bigdecimal")
@JsNonModule
@JsName("MathContext")
external class MathContext

external interface MathContextStatic {
	val DECIMAL128: () -> MathContext
	val DECIMAL64: () -> MathContext
	val DECIMAL32: () -> MathContext
	val UNLIMITED: () -> MathContext
}

@JsModule("bigdecimal")
@JsNonModule
@JsName("RoundingMode")
external enum class RoundingMode

external interface RoundingModeStatic {
	val UP: () -> RoundingMode
	val DOWN: () -> RoundingMode
	val CEILING: () -> RoundingMode
	val FLOOR: () -> RoundingMode
	val HALF_UP: () -> RoundingMode
	val HALF_DOWN: () -> RoundingMode
	val HALF_EVEN: () -> RoundingMode
	val UNNECESSARY: () -> RoundingMode
}