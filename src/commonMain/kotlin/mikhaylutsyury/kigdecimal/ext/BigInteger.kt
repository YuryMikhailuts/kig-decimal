package mikhaylutsyury.kigdecimal.ext

import mikhaylutsyury.kigdecimal.BigInteger
import mikhaylutsyury.kigdecimal.makeBigInteger

fun BigInteger(text: String, radix: Int = 10): BigInteger = makeBigInteger(text, radix)
fun BigInteger(value: Int): BigInteger = makeBigInteger(value)
fun BigInteger(value: Long): BigInteger = makeBigInteger(value)