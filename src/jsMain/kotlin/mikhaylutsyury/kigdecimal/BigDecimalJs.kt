package mikhaylutsyury.kigdecimal

actual typealias BigDecimal = bigdecimal.BigDecimal

actual fun makeBigDecimal(text: String): BigDecimal = bigdecimal.BigDecimal(text)

actual fun makeBigDecimal(value: Int): BigDecimal = bigdecimal.BigDecimal(value)
actual fun makeBigDecimal(value: Long): BigDecimal = bigdecimal.BigDecimal(value)
actual fun makeBigDecimal(value: Float): BigDecimal = bigdecimal.BigDecimal(value)
actual fun makeBigDecimal(value: Double): BigDecimal = bigdecimal.BigDecimal(value)
actual fun makeBigDecimal(value: BigInteger): BigDecimal = bigdecimal.BigDecimal(value)