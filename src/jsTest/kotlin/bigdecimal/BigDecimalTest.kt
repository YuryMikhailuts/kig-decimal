package bigdecimal

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sign
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class BigDecimalTest {
	companion object {
		fun assertEq(expected: BigDecimal, actual: BigDecimal) = assertTrue(
			actual = expected eq actual,
			message = "expected '$expected' but actual '$actual'."
		)
	}


	@Test
	fun constructorTest() {
		for (it in -1000..1000) {
			val BigDecimal = bigdecimal.BigDecimal(it)
			println(BigDecimal)
		}
	}


	@Test
	fun equalsTest() {
		for (it in -1000..1000) {
			val l = BigDecimal(it)
			val r = BigDecimal(it)
			assertTrue { l eq r }
		}
	}

	@Test
	fun absTest() {
		for (it in -1000..1000) {
			val expect = abs(it).toBigDecimal()
			val actual = it.toBigDecimal().abs()
			assertEq(expect, actual)
		}
	}

	@Test
	fun addTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l + r).toBigDecimal()
				val actual = l.toBigDecimal().add(r.toBigDecimal())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun compareToTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				assertTrue { l.compareTo(r) == l.toBigDecimal().compareTo(r.toBigDecimal()) }
			}
		}
	}

	@Test
	fun divideTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				if (r == 0 || l == 0) continue
				val expect = (l.toDouble() / r).toBigDecimal()
				val actual = l.toBigDecimal().divide(r.toBigDecimal(), bigdecimal.MathContext.DECIMAL128())
				assertTrue { expect.subtract(actual).doubleValue() < 0.01 }
			}
		}
	}

	@Test
	fun divideAndRemainderTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				if (r == 0) continue
				val expectDivide = (l / r).toBigDecimal()
				val expectRem = (l.rem(r)).toBigDecimal()
				val (actualDivide, actualRem) = l.toBigDecimal().divideAndRemainder(r.toBigDecimal())
				assertEq(expectDivide, actualDivide)
				assertEq(expectRem, actualRem)
			}
		}
	}

	@Test
	fun doubleValueTest() {
		for (r in -100..100) {
			assertEquals(r.toDouble(), r.toBigDecimal().doubleValue())
		}
	}

	@Test
	fun floatValueTest() {
		for (r in -100..100) {
			assertEquals(r.toFloat(), r.toBigDecimal().floatValue())
		}
	}

	@Test
	fun intValueTest() {
		for (r in -100..100) {
			assertEquals(r, r.toBigDecimal().intValue())
		}
	}

	@Test
	fun maxTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = max(l, r).toBigDecimal()
				val actual = l.toBigDecimal().max(r.toBigDecimal())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun minTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = min(l, r).toBigDecimal()
				val actual = l.toBigDecimal().min(r.toBigDecimal())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun multiplyTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l * r).toBigDecimal()
				val actual = l.toBigDecimal().multiply(r.toBigDecimal())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun negateTest() {
		for (r in -100..100) {
			assertEq((-r).toBigDecimal(), r.toBigDecimal().negate())
		}
	}

	@Test
	fun powTest() {
		for (l in -10..10) {
			for (r in 0..10) {
				println("$l pow $r")
				val expect = (listOf(1L) + List(r) { l.toLong() }).reduce { acc, i -> acc * i }.toBigDecimal()
				val actual = l.toBigDecimal().pow(r)
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun remainderTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				if (r == 0) continue
				val expect = (l.rem(r)).toBigDecimal()
				val actual = l.toBigDecimal().remainder(r.toBigDecimal())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun signumTest() {
		for (r in -100..100) {
			assertEquals(r.sign, r.toBigDecimal().signum())
		}
	}

	@Test
	fun subtractTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l - r).toBigDecimal()
				val actual = l.toBigDecimal().subtract(r.toBigDecimal())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun divideToIntegralValueTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				if (r == 0) continue
				val expect = (l / r).toBigDecimal()
				val actual = l.toBigDecimal().divideToIntegralValue(r.toBigDecimal())
				assertEq(expect, actual)
			}
		}
	}


	@Test
	fun plusTest() {
		for (l in -100..100) {
			val expect = l.toBigDecimal()
			val actual = l.toBigDecimal().plus()
			assertEq(expect, actual)
		}
	}

	@Test
	fun scaleTest() {
		for (l in 1..100) {
			// Бог знает, как это тестировать.
			val actual = 2.toBigDecimal().pow(l).scale()
			println(actual)
		}
	}

	@Test
	fun precisionTest() {
		for (l in 1..100) {
			// Бог знает, как это тестировать.
			val actual = 2.toBigDecimal().pow(l).precision()
			println(actual)
		}
	}

	@Test
	fun unscaledValueTest() {
		for (l in 1..100) {
			// Бог знает, как это тестировать.
			val actual = 2.toBigDecimal().pow(l).unscaledValue()
			println(actual)
		}
	}

	@Test
	fun setScaleTest() {
		for (l in 1..100) {
			// Бог знает, как это тестировать.
			val actual = 2.toBigDecimal().setScale(l)
			println(actual)
		}
	}

	@Test
	fun movePointLeftTest() {
		for (l in 1..100) {
			for (r in 1..100) {
				// Бог знает, как это тестировать.
				println(l.toBigDecimal().movePointLeft(r))
			}
		}
	}

	@Test
	fun movePointRightTest() {
		for (l in 1..100) {
			for (r in 1..100) {
				// Бог знает, как это тестировать.
				println(l.toBigDecimal().movePointRight(r))
			}
		}
	}

	@Test
	fun intValueExactTest() {
		for (r in 1..100) {
			assertEquals(r, r.toBigDecimal().intValue())
		}
	}

	@Test
	fun shortValueExactTest() {
		for (r in 1..100) {
			assertEquals(r.toShort(), r.toBigDecimal().shortValueExact())
		}
	}

	@Test
	fun byteValueExactTest() {
		for (r in 1..100) {
			assertEquals(r.toByte(), r.toBigDecimal().byteValueExact())
		}
	}

}