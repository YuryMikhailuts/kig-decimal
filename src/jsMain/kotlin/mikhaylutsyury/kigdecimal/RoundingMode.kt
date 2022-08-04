package mikhaylutsyury.kigdecimal

actual typealias RoundingMode = bigdecimal.RoundingMode

actual val RoundingModes.UP: RoundingMode get() = bigdecimal.UP
actual val RoundingModes.DOWN: RoundingMode get() = bigdecimal.DOWN
actual val RoundingModes.CEILING: RoundingMode get() = bigdecimal.CEILING
actual val RoundingModes.FLOOR: RoundingMode get() = bigdecimal.FLOOR
actual val RoundingModes.HALF_UP: RoundingMode get() = bigdecimal.HALF_UP
actual val RoundingModes.HALF_DOWN: RoundingMode get() = bigdecimal.HALF_DOWN
actual val RoundingModes.HALF_EVEN: RoundingMode get() = bigdecimal.HALF_EVEN
actual val RoundingModes.UNNECESSARY: RoundingMode get() = bigdecimal.UNNECESSARY
