package mikhaylutsyury.kigdecimal

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
			val bigInteger = makeBigInteger(it)
			println(bigInteger)
		}
	}

	@Test
	fun equalsTest() {
		for (it in -1000..1000) {
			val l = makeBigInteger(it)
			val r = makeBigInteger(it)
			assertTrue { l eq r }
		}
	}

	@Test
	fun absTest() {
		for (it in -1000..1000) {
			val expect = abs(it).toBigInteger()
			val actual = it.toBigInteger().abs()
			assertEq(expect, actual)
		}
	}

	@Test
	fun addTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l + r).toBigInteger()
				val actual = l.toBigInteger().add(r.toBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun andTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l and r).toBigInteger()
				val actual = l.toBigInteger().and(r.toBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun andNotTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l and r.inv()).toBigInteger()
				val actual = l.toBigInteger().andNot(r.toBigInteger())
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
			val i = ((0xFFFFFFFF.toInt() or maskOr) and maskAnd).toBigInteger()
			assertEquals(len + 1, i.bitLength())
		}
	}

	@Test
	fun bitLengthExistsTest() {
		var maskAnd = 1
		for (len in 0..30) {
			val maskOr = 1 shl len
			maskAnd = maskAnd or maskOr
			val i = ((Random.nextInt() or maskOr) and maskAnd).toBigInteger()
			assertEquals(len + 1, i.bitLength())
		}
	}

	@Test
	fun compareToTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				assertTrue { l.compareTo(r) == l.toBigInteger().compareTo(r.toBigInteger()) }
			}
		}
	}

	@Test
	fun divideTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				if (r == 0) continue
				val expect = (l / r).toBigInteger()
				val actual = l.toBigInteger().divide(r.toBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun divideAndRemainderTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				if (r == 0) continue
				val expectDivide = (l / r).toBigInteger()
				val expectRem = (l.rem(r)).toBigInteger()
				val (actualDivide, actualRem) = l.toBigInteger().divideAndRemainder(r.toBigInteger())
				assertEq(expectDivide, actualDivide)
				assertEq(expectRem, actualRem)
			}
		}
	}


	@Test
	fun flipBitTest() {
		for (r in -100..100) {
			for (bit in 0..30) {
				val expect = (r xor (1 shl bit)).toBigInteger()
				val actual = r.toBigInteger().flipBit(bit)
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun hashCodeTest() {
		for (r in -100..100) {
			assertEquals(r.hashCode(), r.toBigInteger().hashCode())
		}
	}

	@Test
	fun maxTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = max(l, r).toBigInteger()
				val actual = l.toBigInteger().max(r.toBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun minTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = min(l, r).toBigInteger()
				val actual = l.toBigInteger().min(r.toBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun modTest() {
		for (l in -100..100) {
			for (r in 1..100) {
				val expect = (l.mod(r)).toBigInteger()
				val actual = l.toBigInteger().mod(r.toBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun multiplyTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l * r).toBigInteger()
				val actual = l.toBigInteger().multiply(r.toBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun negateTest() {
		for (r in -100..100) {
			assertEq((-r).toBigInteger(), r.toBigInteger().negate())
		}
	}

	@Test
	fun nextProbablePrimeTest() {
		val primes = listOf(1, 2, 3, 5, 7, 11, 13)
		for ((r, l) in primes.windowed(2)) {
			assertEq(l.toBigInteger(), r.toBigInteger().nextProbablePrime())
		}
	}

	@Test
	fun notTest() {
		for (r in -100..100) {
			assertEq(r.inv().toBigInteger(), r.toBigInteger().not())
		}
	}

	@Test
	fun orTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l or r).toBigInteger()
				val actual = l.toBigInteger().or(r.toBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun powTest() {
		for (l in -10..10) {
			for (r in 0..10) {
				println("$l pow $r")
				val expect = (listOf(1L) + List(r) { l.toLong() }).reduce { acc, i -> acc * i }.toBigInteger()
				val actual = l.toBigInteger().pow(r)
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun remainderTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				if (r == 0) continue
				val expect = (l.rem(r)).toBigInteger()
				val actual = l.toBigInteger().remainder(r.toBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun shiftLeftTest() {
		for (l in -100..100) {
			for (r in 0..10) {
				val expect = (l.shl(r)).toBigInteger()
				val actual = l.toBigInteger().shiftLeft(r)
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun shiftRightTest() {
		for (l in -100..100) {
			for (r in 0..10) {
				val expect = (l.shr(r)).toBigInteger()
				val actual = l.toBigInteger().shiftRight(r)
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun signumTest() {
		for (r in -100..100) {
			assertEquals(r.sign, r.toBigInteger().signum())
		}
	}

	@Test
	fun subtractTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l - r).toBigInteger()
				val actual = l.toBigInteger().subtract(r.toBigInteger())
				assertEq(expect, actual)
			}
		}
	}

	@Test
	fun testBitTest() {
		for (l in -100..100) {
			for (r in 0..10) {
				val expect = l and (1 shl r) != 0
				val actual = l.toBigInteger().testBit(r)
				assertEquals(expect, actual)
			}
		}
	}

	@Test
	fun xorTest() {
		for (l in -100..100) {
			for (r in -100..100) {
				val expect = (l xor r).toBigInteger()
				val actual = l.toBigInteger().xor(r.toBigInteger())
				assertEq(expect, actual)
			}
		}
	}
}