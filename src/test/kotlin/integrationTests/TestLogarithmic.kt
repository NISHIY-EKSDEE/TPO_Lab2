package integrationTests

import logarithmic.Ln
import logarithmic.Log2
import logarithmic.Log5
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.mockito.Mockito
import kotlin.math.E
import kotlin.test.assertFailsWith

class TestLogarithmic {
    companion object {
        private val acc = 0.0001
        private val lnMock = Mockito.mock(Ln::class.java)

        @BeforeAll
        @JvmStatic
        fun init() {

            Mockito.`when`(lnMock(-1.0)).thenThrow(IllegalArgumentException("Аргумент вне ОДЗ"))
            Mockito.`when`(lnMock(0.0)).thenThrow(IllegalArgumentException("Аргумент вне ОДЗ"))
            Mockito.`when`(lnMock(0.5)).thenReturn(-0.6931471805599453)
            Mockito.`when`(lnMock(1.0)).thenReturn(0.0)
            Mockito.`when`(lnMock(2.0)).thenReturn(0.6931471805599453)
            Mockito.`when`(lnMock(E)).thenReturn(1.0)
            Mockito.`when`(lnMock(3.5)).thenReturn(1.252762968495368)
            Mockito.`when`(lnMock(5.0)).thenReturn(1.6094379124341003)
        }
    }

    @Test
    fun `log2(x) test`() {
        val log2 = Log2(acc, lnMock)

        Assertions.assertAll(
            { assertFailsWith<IllegalArgumentException> { log2(-1.0) } },
            { assertFailsWith<IllegalArgumentException> { log2(0.0) } },
            { Assert.assertEquals(-1.0, log2(0.5), acc) },
            { Assert.assertEquals(0.0, log2(1.0), acc) },
            { Assert.assertEquals(1.0, log2(2.0), acc) },
            { Assert.assertEquals(1.442695040889, log2(E), acc) },
            { Assert.assertEquals(1.8073549220576042, log2(3.5), acc) },
        )
    }

    @Test
    fun `log5(x) test`() {
        val log5 = Log5(acc, lnMock)

        Assertions.assertAll(
            { assertFailsWith<IllegalArgumentException> { log5(-1.0) } },
            { assertFailsWith<IllegalArgumentException> { log5(0.0) } },
            { Assert.assertEquals(-0.43067655807, log5(0.5), acc) },
            { Assert.assertEquals(0.0, log5(1.0), acc) },
            { Assert.assertEquals(0.43067655807, log5(2.0), acc) },
            { Assert.assertEquals(0.62133493456, log5(E), acc) },
            { Assert.assertEquals(0.77838539705, log5(3.5), acc) },
            { Assert.assertEquals(1.0, log5(5.0), acc) },
        )
    }
}