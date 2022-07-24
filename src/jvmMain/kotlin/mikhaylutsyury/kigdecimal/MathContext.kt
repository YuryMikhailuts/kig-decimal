package mikhaylutsyury.kigdecimal

actual typealias MathContext = java.math.MathContext

actual val MathContexts.DECIMAL128: MathContext get() = MathContext.DECIMAL128
actual val MathContexts.DECIMAL64: MathContext get() = MathContext.DECIMAL64
actual val MathContexts.DECIMAL32: MathContext get() = MathContext.DECIMAL32
actual val MathContexts.UNLIMITED: MathContext get() = MathContext.UNLIMITED