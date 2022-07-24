package bigdecimal

external interface BigDecimalModule {
	fun BigInteger(text: String, notation: Int): BigInteger
}

val bigdecimal: BigDecimalModule by lazy { js("require(\"bigdecimal\")").unsafeCast<BigDecimalModule>() }

fun BigInteger(text: String, notation: Int = 10) = bigdecimal.BigInteger(text, notation)

fun BigInteger(value: Int) = BigInteger("$value")

fun Int.asBigInteger() = BigInteger(this)

fun BigInteger(value: Long) = BigInteger("$value")

fun Long.asBigInteger() = BigInteger(this)

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
external class BigDecimal(text: String) {

}