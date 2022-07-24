package mikhaylutsyury.kigdecimal

actual typealias BigInteger = bigdecimal.BigInteger

actual fun makeBigInteger(value: Long): BigInteger = bigdecimal.BigInteger(value)

actual fun makeBigInteger(text: String, radix: Int): BigInteger = bigdecimal.BigInteger(text, radix)

actual fun makeBigInteger(value: Int): BigInteger = bigdecimal.BigInteger(value)