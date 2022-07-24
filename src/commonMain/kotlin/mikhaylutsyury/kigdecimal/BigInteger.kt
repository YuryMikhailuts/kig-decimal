package mikhaylutsyury.kigdecimal

expect class BigInteger {
	fun abs(): BigInteger
	fun add(other: BigInteger): BigInteger
	fun and(other: BigInteger): BigInteger
	fun andNot(other: BigInteger): BigInteger
	fun bitCount(): Int
	fun bitLength(): Int
	fun compareTo(other: BigInteger): Int
	fun divide(other: BigInteger): BigInteger
	fun divideAndRemainder(other: BigInteger): Array<BigInteger>
	fun flipBit(n: Int): BigInteger
	override fun hashCode(): Int
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
	override fun equals(other: Any?): Boolean
}

infix fun BigInteger.eq(other: BigInteger) = compareTo(other) == 0


expect fun makeBigInteger(text: String, radix: Int = 10): BigInteger
expect fun makeBigInteger(value: Int): BigInteger
expect fun makeBigInteger(value: Long): BigInteger
fun Int.toBigInteger() = makeBigInteger(this)
fun Long.toBigInteger() = makeBigInteger(this)
