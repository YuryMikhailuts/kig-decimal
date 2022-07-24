package mikhaylutsyury.kigdecimal

actual typealias BigDecimal = java.math.BigDecimal

actual fun makeBigDecimal(text: String): BigDecimal = java.math.BigDecimal(text)
actual fun makeBigDecimal(value: Int): BigDecimal = BigDecimal.valueOf(value.toLong())
actual fun makeBigDecimal(value: Long): BigDecimal = BigDecimal.valueOf(value)
actual fun makeBigDecimal(value: Float): BigDecimal = BigDecimal.valueOf(value.toDouble())
actual fun makeBigDecimal(value: Double): BigDecimal = BigDecimal.valueOf(value)