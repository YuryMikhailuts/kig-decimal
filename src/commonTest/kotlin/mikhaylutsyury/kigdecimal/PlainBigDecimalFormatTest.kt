package mikhaylutsyury.kigdecimal

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

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


	@Test
	fun errorTest() {
		val format = PlainBigDecimalFormat(3U, 2U) { "Value is BAD." }
		val good = 999.99.toBigDecimal()
		val bad = 1000.99.toBigDecimal()
		kotlin.runCatching {
			println("good = ${good.toString(format)}")
		}.onFailure { assertTrue("Unexpected exception $it.") { false } }
		assertFailsWith<IllegalArgumentException> { println("bad = ${bad.toString(format)}") }
	}
}