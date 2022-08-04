package mikhaylutsyury.kigdecimal

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

internal class PlainBigDecimalFormatTest {

	@Test
	fun test() {
		val format = PlainBigDecimalFormat(10U, 10U)
		repeat(100) {
			val double = Random.nextDouble(-1000.0, 1000.0)
			val value = double.toBigDecimal()
			val valueStr = value.toString(format)
			val doubleStr = "$double".substring(0, valueStr.length)
			assertEquals(doubleStr, valueStr)
			println("$doubleStr = $valueStr")
		}
	}

}