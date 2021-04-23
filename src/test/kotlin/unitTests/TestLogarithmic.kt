package unitTests

import integrationTests.TestLogarithmic
import logarithmic.Ln
import logarithmic.Log2
import logarithmic.Log5
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.Assertions
import trigonometric.Sin
import kotlin.math.E
import kotlin.math.PI
import kotlin.test.assertFailsWith

class TestLogarithmic {
    private val acc = 0.001

    @Test
    fun `ln(x) test`() {
        val ln = Ln(acc)

        Assertions.assertAll(
            { assertFailsWith<IllegalArgumentException> { ln(-1.0) } },
            { assertFailsWith<IllegalArgumentException> { ln(0.0) } },
            { Assert.assertEquals(-0.6931471805599453, ln(0.5), acc) },
            { Assert.assertEquals(0.0, ln(1.0), acc) },
            { Assert.assertEquals(0.6931471805599453, ln(2.0), acc) },
            { Assert.assertEquals(1.0, ln(E), acc) },
            { Assert.assertEquals(1.252762968495368, ln(3.5), acc) },
        )
    }

    @org.junit.jupiter.api.Test
    fun `log2(x) test`() {
        val log2 = Log2(acc)

        Assertions.assertAll(
            { assertFailsWith<IllegalArgumentException> { log2(-1.0) } },
            { assertFailsWith<IllegalArgumentException> { log2(0.0) } },
            { Assert.assertEquals(0.0, log2(1.0), acc) },
            { Assert.assertEquals(1.0, log2(2.0), acc) },
            { Assert.assertEquals(1.442695040889, log2(E), acc) },
            { Assert.assertEquals(1.8073549220576042, log2(3.5), acc) },
        )
    }

    @org.junit.jupiter.api.Test
    fun `log5(x) test`() {
        val log5 = Log5(acc)

        Assertions.assertAll(
            { assertFailsWith<IllegalArgumentException> { log5(-1.0) } },
            { assertFailsWith<IllegalArgumentException> { log5(0.0) } },
            { Assert.assertEquals(0.0, log5(1.0), acc) },
            { Assert.assertEquals(0.43067655807, log5(2.0), acc) },
            { Assert.assertEquals(0.62133493456, log5(E), acc) },
            { Assert.assertEquals(0.77838539705, log5(3.5), acc) },
            { Assert.assertEquals(1.0, log5(5.0), acc) },
        )
    }
}