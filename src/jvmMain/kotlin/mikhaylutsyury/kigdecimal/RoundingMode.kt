package mikhaylutsyury.kigdecimal

actual typealias RoundingMode = java.math.RoundingMode

actual val RoundingModes.UP: RoundingMode get() = java.math.RoundingMode.UP
actual val RoundingModes.DOWN: RoundingMode get() = java.math.RoundingMode.DOWN
actual val RoundingModes.CEILING: RoundingMode get() = java.math.RoundingMode.CEILING
actual val RoundingModes.FLOOR: RoundingMode get() = java.math.RoundingMode.FLOOR
actual val RoundingModes.HALF_UP: RoundingMode get() = java.math.RoundingMode.HALF_UP
actual val RoundingModes.HALF_DOWN: RoundingMode get() = java.math.RoundingMode.HALF_DOWN
actual val RoundingModes.HALF_EVEN: RoundingMode get() = java.math.RoundingMode.HALF_EVEN
actual val RoundingModes.UNNECESSARY: RoundingMode get() = java.math.RoundingMode.UNNECESSARY
