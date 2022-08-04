package mikhaylutsyury.kigdecimal.ext

import mikhaylutsyury.kigdecimal.BigDecimal
import mikhaylutsyury.kigdecimal.BigInteger
import mikhaylutsyury.kigdecimal.makeBigDecimal
import mikhaylutsyury.kigdecimal.toBigDecimal

fun BigDecimal(text: String): BigDecimal = makeBigDecimal(text)
fun BigDecimal(value: Int): BigDecimal = makeBigDecimal(value)
fun BigDecimal(value: Long): BigDecimal = makeBigDecimal(value)
fun BigDecimal(value: Float): BigDecimal = makeBigDecimal(value)
fun BigDecimal(value: Double): BigDecimal = makeBigDecimal(value)
fun BigDecimal(value: BigInteger): BigDecimal = makeBigDecimal(value)

fun BigDecimal.copy() = BigDecimal("$this")

fun BigDecimal.intValue() = "$this".toInt()
fun BigDecimal.longValue() = "$this".toLong()
fun BigDecimal.uIntValue() = "$this".toUInt()
fun BigDecimal.uLongValue() = "$this".toULong()
fun BigDecimal.floatValue() = "$this".toFloat()
fun BigDecimal.doubleValue() = "$this".toDouble()

operator fun BigDecimal.unaryMinus() = 0.toBigDecimal() - this
operator fun BigDecimal.unaryPlus() = this
operator fun BigDecimal.inc() = this + 1
operator fun BigDecimal.dec() = this - 1
operator fun BigDecimal.plus(other: BigDecimal) = add(other)
operator fun BigDecimal.minus(other: BigDecimal) = subtract(other)
operator fun BigDecimal.times(other: BigDecimal) = multiply(other)
operator fun BigDecimal.div(other: BigDecimal) = divide(other)

operator fun BigDecimal.plus(other: Int) = add(other.toBigDecimal())
operator fun BigDecimal.minus(other: Int) = subtract(other.toBigDecimal())
operator fun BigDecimal.times(other: Int) = multiply(other.toBigDecimal())
operator fun BigDecimal.div(other: Int) = divide(other.toBigDecimal())
operator fun BigDecimal.plus(other: Long) = add(other.toBigDecimal())
operator fun BigDecimal.minus(other: Long) = subtract(other.toBigDecimal())
operator fun BigDecimal.times(other: Long) = multiply(other.toBigDecimal())
operator fun BigDecimal.div(other: Long) = divide(other.toBigDecimal())
operator fun BigDecimal.plus(other: BigInteger) = add(other.toBigDecimal())
operator fun BigDecimal.minus(other: BigInteger) = subtract(other.toBigDecimal())
operator fun BigDecimal.times(other: BigInteger) = multiply(other.toBigDecimal())
operator fun BigDecimal.div(other: BigInteger) = divide(other.toBigDecimal())
operator fun BigDecimal.plus(other: Float) = add(other.toBigDecimal())
operator fun BigDecimal.minus(other: Float) = subtract(other.toBigDecimal())
operator fun BigDecimal.times(other: Float) = multiply(other.toBigDecimal())
operator fun BigDecimal.div(other: Float) = divide(other.toBigDecimal())
operator fun BigDecimal.plus(other: Double) = add(other.toBigDecimal())
operator fun BigDecimal.minus(other: Double) = subtract(other.toBigDecimal())
operator fun BigDecimal.times(other: Double) = multiply(other.toBigDecimal())
operator fun BigDecimal.div(other: Double) = divide(other.toBigDecimal())

/**
 * Оператор сравнения.
 * Несмотря на то, что, на первый взгляд, тут должна быть рекурсия, её тут нет.
 * Но это никакая не магия. Просто функция-член класса [BigDecimal.compareTo] при вызове имеет приоритет перед функцией расширения.
 */
operator fun BigDecimal.compareTo(other: BigDecimal) = compareTo(other)