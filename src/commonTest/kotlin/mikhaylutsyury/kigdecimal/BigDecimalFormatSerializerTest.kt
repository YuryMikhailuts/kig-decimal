package mikhaylutsyury.kigdecimal

import kotlinx.serialization.json.Json
import kotlin.test.Ignore
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

	private val testData = listOf(
		1.23.toBigDecimal() to "\"001,230\"",
		1234.5678.toBigDecimal() to "\"234,567\"",
		(-987.5678).toBigDecimal() to "\"-987,567\"",
	)

	@Ignore
	@Test
	fun test2() {
		testData.forEach { (dto, expected) ->
			val actual = Json.encodeToString(TestBigDecimalFormatSerializer, dto)
			println("'$expected' = '$actual'")
			assertEquals(expected, actual)
		}
	}

}