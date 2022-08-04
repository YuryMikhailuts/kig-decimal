package mikhaylutsyury.kigdecimal.ext

import mikhaylutsyury.kigdecimal.BigDecimal
import mikhaylutsyury.kigdecimal.BigInteger
import mikhaylutsyury.kigdecimal.makeBigDecimal

fun BigDecimal(text: String): BigDecimal = makeBigDecimal(text)
fun BigDecimal(value: Int): BigDecimal = makeBigDecimal(value)
fun BigDecimal(value: Long): BigDecimal = makeBigDecimal(value)
fun BigDecimal(value: Float): BigDecimal = makeBigDecimal(value)
fun BigDecimal(value: Double): BigDecimal = makeBigDecimal(value)
fun BigDecimal(value: BigInteger): BigDecimal = makeBigDecimal(value)

fun BigDecimal.copy() = BigDecimal("$this")