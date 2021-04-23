package integrationTests

import org.junit.Assert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import trigonometric.*
import kotlin.IllegalArgumentException
import kotlin.math.PI
import kotlin.math.cos
import kotlin.test.assertFailsWith

class TestTrigonometric {
    companion object {
        private val acc = 0.0001
        private val sinMock = Mockito.mock(Sin::class.java)
        private val cosMock = Mockito.mock(Cos::class.java)
        private val tanMock = Mockito.mock(Tan::class.java)
        private val cotMock = Mockito.mock(Cot::class.java)
        private val cscMock = Mockito.mock(Csc::class.java)

        @BeforeAll
        @JvmStatic
        fun init() {
            Mockito.`when`(sinMock(-PI)).thenReturn(0.0)
            Mockito.`when`(cosMock(-PI)).thenReturn(-1.0)
            Mockito.`when`(tanMock(-PI)).thenReturn(0.0)
            Mockito.`when`(cotMock(-PI)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))
            Mockito.`when`(cscMock(-PI)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))

            Mockito.`when`(sinMock(-2.0)).thenReturn(-0.9092974268256817)
            Mockito.`when`(cosMock(-2.0)).thenReturn(-0.4161468365471424)
            Mockito.`when`(tanMock(-2.0)).thenReturn(2.185039863261519)
            Mockito.`when`(cotMock(-2.0)).thenReturn(0.45765755436028577)
            Mockito.`when`(cscMock(-2.0)).thenReturn(-1.0997501702946164)

            Mockito.`when`(sinMock(-PI / 2)).thenReturn(-1.0)
            Mockito.`when`(cosMock(-PI / 2)).thenReturn(0.0)
            Mockito.`when`(tanMock(-PI / 2)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))
            Mockito.`when`(cotMock(-PI / 2)).thenReturn(0.0)
            Mockito.`when`(cscMock(-PI / 2)).thenReturn(-1.0)

            Mockito.`when`(sinMock(-0.5)).thenReturn(-0.4794255386042)
            Mockito.`when`(cosMock(-0.5)).thenReturn(0.8775825618903728)
            Mockito.`when`(tanMock(-0.5)).thenReturn(-0.5463024898437905)
            Mockito.`when`(cotMock(-0.5)).thenReturn(-1.830487721712452)
            Mockito.`when`(cscMock(-0.5)).thenReturn(-2.085829642933488)

            Mockito.`when`(sinMock(0.0)).thenReturn(0.0)
            Mockito.`when`(cosMock(0.0)).thenReturn(1.0)
            Mockito.`when`(tanMock(0.0)).thenReturn(0.0)
            Mockito.`when`(cotMock(0.0)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))
            Mockito.`when`(cscMock(0.0)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))

            Mockito.`when`(sinMock(0.5)).thenReturn(0.4794255386042)
            Mockito.`when`(cosMock(0.5)).thenReturn(0.8775825618903728)
            Mockito.`when`(tanMock(0.5)).thenReturn(0.6131052132881357)
            Mockito.`when`(cotMock(0.5)).thenReturn(1.830487721712452)
            Mockito.`when`(cscMock(0.5)).thenReturn(2.085829642933488)

            Mockito.`when`(sinMock(PI / 2)).thenReturn(1.0)
            Mockito.`when`(cosMock(PI / 2)).thenReturn(0.0)
            Mockito.`when`(tanMock(PI / 2)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))
            Mockito.`when`(cotMock(PI / 2)).thenReturn(0.0)
            Mockito.`when`(cscMock(PI / 2)).thenReturn(1.0)

            Mockito.`when`(sinMock(2.0)).thenReturn(0.9092974268256817)
            Mockito.`when`(cosMock(2.0)).thenReturn(-0.4161468365471424)
            Mockito.`when`(tanMock(2.0)).thenReturn(-2.185039863261519)
            Mockito.`when`(cotMock(2.0)).thenReturn(-0.45765755436028577)
            Mockito.`when`(cscMock(2.0)).thenReturn(1.0997501702946164)

            Mockito.`when`(sinMock(PI)).thenReturn(0.0)
            Mockito.`when`(cosMock(PI)).thenReturn(-1.0)
            Mockito.`when`(tanMock(PI)).thenReturn(0.0)
            Mockito.`when`(cotMock(PI)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))
            Mockito.`when`(cscMock(PI)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))
        }
    }

    @Test
    fun `cot(x) test`() {
        val cot = Cot(acc, sinMock, cosMock)

        Assertions.assertAll(
            { assertFailsWith<java.lang.IllegalArgumentException> { cot(PI) } },
            { assertFailsWith<java.lang.IllegalArgumentException> { cot(-PI) } },
            { assertFailsWith<java.lang.IllegalArgumentException> { cot(0.0) } },
            { Assertions.assertEquals(0.45765755436028577, cot(-2.0), acc) },
            { Assertions.assertEquals(0.0, cot(-PI / 2), acc) },
            { Assertions.assertEquals(-1.830487721712452, cot(-0.5), acc) },
            { Assertions.assertEquals(1.830487721712452, cot(0.5), acc) },
            { Assertions.assertEquals(0.0, cot(PI / 2), acc) },
            { Assertions.assertEquals(-0.45765755436028577, cot(2.0), acc) }
        )
    }

    @Test fun `tan(x) test`() {
        val tan = Tan(acc, sinMock, cosMock)

        Assertions.assertAll(
            { assertFailsWith<java.lang.IllegalArgumentException> { tan(-PI / 2) } },
            { assertFailsWith<java.lang.IllegalArgumentException> { tan(PI / 2) } },
            { Assert.assertEquals(2.185039863261519, tan(-2.0), acc) },
            { Assert.assertEquals(0.0, tan(0.0), acc) },
            { Assert.assertEquals(0.5463024898437905, tan(0.5), acc) },
            { Assert.assertEquals(0.0, tan(PI), acc) },
            { Assert.assertEquals(-2.185039863261519, tan(2.0), acc) }
        )
    }

    @Test fun `csc(x) test`() {
        val csc = Csc(acc, sinMock)

        Assertions.assertAll(
            { assertFailsWith<java.lang.IllegalArgumentException> { csc(-PI) } },
            { assertFailsWith<java.lang.IllegalArgumentException> { csc(PI) } },
            { assertFailsWith<java.lang.IllegalArgumentException> { csc(0.0) } },
            { Assert.assertEquals(-1.0997501702946164, csc(-2.0), acc) },
            { Assert.assertEquals(-1.0, csc(-PI / 2), acc) },
            { Assert.assertEquals(-2.085829642933488, csc(-0.5), acc) },
            { Assert.assertEquals(2.085829642933488, csc(0.5), acc) },
            { Assert.assertEquals(1.0, csc(PI / 2), acc) },
            { Assert.assertEquals(1.0997501702946164, csc(2.0), acc) }
        )
    }
}