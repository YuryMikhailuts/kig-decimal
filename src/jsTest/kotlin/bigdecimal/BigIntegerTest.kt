package bigdecimal

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sign
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BigIntegerTest {
	companion object {
		fun assertEq(expected: BigInteger, actual: BigInteger) = assertTrue(
			actual = expected eq actual,
			message = "expected '$expected' but actual '$actual'."
		)
	}


	@Test
	fun constructorTest() {
		for (it in -1000..1000) {
			val bigInteger = BigInteger("$it")
			println(bigInteger)
		}
	}

	@Test
	fun equalsTest() {
		for (it in -1000..1000) {
			val l = BigInteger(it)
			val r = BigInteger(it)
			assertTrue { l eq r }
		}
	}

	@Test
	fun absTest() {
		for (it in -1000..1000) {
			val expect = abs(it).asBigInteger()
			val actual = it.asBigInteger().abs()
			assertEq(expect, actual)
		}
	}

	@Test
	fun addTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l + r).asBigInteger()
				val actual = l.asBigInteger().add(r.asBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun andTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l and r).asBigInteger()
				val actual = l.asBigInteger().and(r.asBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun andNotTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l and r.inv()).asBigInteger()
				val actual = l.asBigInteger().andNot(r.asBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun bitCountTest() {
		var maskAnd = 1
		for (len in 0..30) {
			val maskOr = 1 shl len
			maskAnd = maskAnd or maskOr
			val i = ((0xFFFFFFFF.toInt() or maskOr) and maskAnd).asBigInteger()
			assertEquals(len + 1, i.bitLength())
		}
	}

	@Test
	fun bitLengthExistsTest() {
		var maskAnd = 1
		for (len in 0..30) {
			val maskOr = 1 shl len
			maskAnd = maskAnd or maskOr
			val i = ((Random.nextInt() or maskOr) and maskAnd).asBigInteger()
			assertEquals(len + 1, i.bitLength())
		}
	}

	@Test
	fun compareToTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				assertTrue { l.compareTo(r) == l.asBigInteger().compareTo(r.asBigInteger()) }
			}
		}
	}

	@Test
	fun divideTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				if (r == 0) continue
				val expect = (l / r).asBigInteger()
				val actual = l.asBigInteger().divide(r.asBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun divideAndRemainderTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				if (r == 0) continue
				val expectDivide = (l / r).asBigInteger()
				val expectRem = (l.rem(r)).asBigInteger()
				val (actualDivide, actualRem) = l.asBigInteger().divideAndRemainder(r.asBigInteger())
				assertEq(expectDivide, actualDivide)
				assertEq(expectRem, actualRem)
			}
		}
	}

	@Test
	fun doubleValueTest() {
		for (r in -100..100) {
			assertEquals(r.toDouble(), r.asBigInteger().doubleValue())
		}
	}

	@Test
	fun flipBitTest() {
		for (r in -100..100) {
			for (bit in 0..30) {
				val expect = (r xor (1 shl bit)).asBigInteger()
				val actual = r.asBigInteger().flipBit(bit)
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun floatValueTest() {
		for (r in -100..100) {
			assertEquals(r.toFloat(), r.asBigInteger().floatValue())
		}
	}

	@Test
	fun hashCodeTest() {
		for (r in -100..100) {
			assertEquals(r.hashCode(), r.asBigInteger().hashCode())
		}
	}

	@Test
	fun intValueTest() {
		for (r in -100..100) {
			assertEquals(r, r.asBigInteger().intValue())
		}
	}

	@Test
	fun maxTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = max(l, r).asBigInteger()
				val actual = l.asBigInteger().max(r.asBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun minTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = min(l, r).asBigInteger()
				val actual = l.asBigInteger().min(r.asBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun modTest() {
		for (l in -100..100) {
			for (r in 1..100) {
				val expect = (l.mod(r)).asBigInteger()
				val actual = l.asBigInteger().mod(r.asBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun multiplyTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l * r).asBigInteger()
				val actual = l.asBigInteger().multiply(r.asBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun negateTest() {
		for (r in -100..100) {
			assertEq((-r).asBigInteger(), r.asBigInteger().negate())
		}
	}

	@Test
	fun nextProbablePrimeTest() {
		val primes = listOf(1, 2, 3, 5, 7, 11, 13)
		for ((r, l) in primes.windowed(2)) {
			assertEq(l.asBigInteger(), r.asBigInteger().nextProbablePrime())
		}
	}

	@Test
	fun notTest() {
		for (r in -100..100) {
			assertEq(r.inv().asBigInteger(), r.asBigInteger().not())
		}
	}

	@Test
	fun orTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l or r).asBigInteger()
				val actual = l.asBigInteger().or(r.asBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun powTest() {
		for (l in -10..10) {
			for (r in 0..10) {
				println("$l pow $r")
				val expect = (listOf(1L) + List(r) { l.toLong() }).reduce { acc, i -> acc * i }.asBigInteger()
				val actual = l.asBigInteger().pow(r)
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun remainderTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				if (r == 0) continue
				val expect = (l.rem(r)).asBigInteger()
				val actual = l.asBigInteger().remainder(r.asBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun shiftLeftTest() {
		for (l in -100..100) {
			for (r in 0..10) {
				val expect = (l.shl(r)).asBigInteger()
				val actual = l.asBigInteger().shiftLeft(r)
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun shiftRightTest() {
		for (l in -100..100) {
			for (r in 0..10) {
				val expect = (l.shr(r)).asBigInteger()
				val actual = l.asBigInteger().shiftRight(r)
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun signumTest() {
		for (r in -100..100) {
			assertEquals(r.sign, r.asBigInteger().signum())
		}
	}

	@Test
	fun subtractTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l - r).asBigInteger()
				val actual = l.asBigInteger().subtract(r.asBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun testBitTest() {
		for (l in -100..100) {
			for (r in 0..10) {
				val expect = l and (1 shl r) != 0
				val actual = l.asBigInteger().testBit(r)
				assertEquals(expect, actual)
			}
		}
	}

	@Test
	fun xorTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l xor r).asBigInteger()
				val actual = l.asBigInteger().xor(r.asBigInteger())
				assertEq(expect, actual)
			}
		}
	}
}