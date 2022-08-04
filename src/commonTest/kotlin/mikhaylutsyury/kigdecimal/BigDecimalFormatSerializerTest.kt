package mikhaylutsyury.kigdecimal

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

internal class BigDecimalFormatSerializerTest {

	object TestBigDecimalFormatSerializer : BigDecimalFormatSerializer(
		format = PlainBigDecimalFormat(
			integersCount = 3U,
			fractionsCount = 3U,
			addZeroLeft = true,
			addZeroRight = true,
			decimalDot = ",",
		)
	)

	@Serializable
	data class TestDTO(
		@Serializable(TestBigDecimalFormatSerializer::class)
		val value: BigDecimal
	)

	private val testData = listOf(
		TestDTO(1.23.toBigDecimal()) to """{"value":"001,230"}""",
		TestDTO(1234.5678.toBigDecimal()) to """{"value":"234,567"}""",
		TestDTO((-987.5678).toBigDecimal()) to """{"value":"-987,567"}""",
	)

	@Test
	fun test2() {
		testData.forEach { (dto, expected) ->
			val actual = Json.encodeToString(dto)
			println("'$expected' = '$actual'")
			assertEquals(expected, actual)
		}
	}

}