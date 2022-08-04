package mikhaylutsyury.kigdecimal.ext

import mikhaylutsyury.kigdecimal.BigInteger
import mikhaylutsyury.kigdecimal.makeBigInteger
import mikhaylutsyury.kigdecimal.toBigInteger

fun BigInteger(text: String, radix: Int = 10): BigInteger = makeBigInteger(text, radix)
fun BigInteger(value: Int): BigInteger = makeBigInteger(value)
fun BigInteger(value: Long): BigInteger = makeBigInteger(value)

fun BigInteger.copy() = BigInteger("$this")

fun BigInteger.intValue() = "$this".toInt()
fun BigInteger.longValue() = "$this".toLong()
fun BigInteger.uIntValue() = "$this".toUInt()
fun BigInteger.uLongValue() = "$this".toULong()

operator fun BigInteger.unaryMinus() = 0.toBigInteger() - this
operator fun BigInteger.unaryPlus() = this
operator fun BigInteger.inc() = this + 1
operator fun BigInteger.dec() = this - 1
operator fun BigInteger.plus(other: BigInteger) = add(other)
operator fun BigInteger.minus(other: BigInteger) = subtract(other)
operator fun BigInteger.times(other: BigInteger) = multiply(other)
operator fun BigInteger.div(other: BigInteger) = divide(other)

operator fun BigInteger.plus(other: Int) = add(other.toBigInteger())
operator fun BigInteger.minus(other: Int) = subtract(other.toBigInteger())
operator fun BigInteger.times(other: Int) = multiply(other.toBigInteger())
operator fun BigInteger.div(other: Int) = divide(other.toBigInteger())
operator fun BigInteger.plus(other: Long) = add(other.toBigInteger())
operator fun BigInteger.minus(other: Long) = subtract(other.toBigInteger())
operator fun BigInteger.times(other: Long) = multiply(other.toBigInteger())
operator fun BigInteger.div(other: Long) = divide(other.toBigInteger())

/**
 * Оператор сравнения.
 * Несмотря на то, что, на первый взгляд, тут должна быть рекурсия, её тут нет.
 * Но это никакая не магия. Просто функция-член класса [BigInteger.compareTo] при вызове имеет приоритет перед функцией расширения.
 */
operator fun BigInteger.compareTo(other: BigInteger) = compareTo(other)
