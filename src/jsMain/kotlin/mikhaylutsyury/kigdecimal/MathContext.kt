package mikhaylutsyury.kigdecimal

actual typealias MathContext = bigdecimal.MathContext


actual val MathContexts.DECIMAL128: MathContext get() = bigdecimal.DECIMAL128
actual val MathContexts.DECIMAL64: MathContext get() = bigdecimal.DECIMAL64
actual val MathContexts.DECIMAL32: MathContext get() = bigdecimal.DECIMAL32
actual val MathContexts.UNLIMITED: MathContext get() = bigdecimal.UNLIMITED