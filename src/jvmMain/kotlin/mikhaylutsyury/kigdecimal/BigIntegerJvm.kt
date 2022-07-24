package mikhaylutsyury.kigdecimal

import mikhaylutsyury.kigdecimal.ext.BigInteger

actual typealias BigInteger = java.math.BigInteger

actual fun makeBigInteger(value: Int): BigInteger = BigInteger.valueOf(value.toLong())

actual fun makeBigInteger(value: Long): BigInteger = BigInteger.valueOf(value)

actual fun makeBigInteger(text: String, radix: Int): BigInteger = BigInteger(text, radix)