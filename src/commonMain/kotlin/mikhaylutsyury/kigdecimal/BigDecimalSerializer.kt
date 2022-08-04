package mikhaylutsyury.kigdecimal

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import mikhaylutsyury.kigdecimal.ext.BigDecimal

@Suppress("OPT_IN_IS_NOT_ENABLED")
@OptIn(ExperimentalSerializationApi::class)
@Serializer(BigDecimal::class)
object BigDecimalSerializer : KSerializer<BigDecimal> {
	override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("BigDecimal", PrimitiveKind.STRING)

	override fun deserialize(decoder: Decoder): BigDecimal = BigDecimal(decoder.decodeString())

	override fun serialize(encoder: Encoder, value: BigDecimal) {
		encoder.encodeString("$value")
	}

}