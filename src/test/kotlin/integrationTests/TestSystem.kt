package integrationTests

import logarithmic.Ln
import logarithmic.Log2
import logarithmic.Log5
import org.junit.Assert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import system.SystemFunction
import trigonometric.*
import kotlin.math.E
import kotlin.math.PI
import kotlin.test.assertFailsWith

class TestSystem {
    companion object {
        private val acc = 0.0001
        private val lnMock = Mockito.mock(Ln::class.java)
        private val log2Mock = Mockito.mock(Log2::class.java)
        private val log5Mock = Mockito.mock(Log5::class.java)

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


            Mockito.`when`(lnMock(-1.0)).thenThrow(IllegalArgumentException("Аргумент вне ОДЗ"))
            Mockito.`when`(lnMock(0.0)).thenThrow(IllegalArgumentException("Аргумент вне ОДЗ"))
            Mockito.`when`(lnMock(0.5)).thenReturn(-0.6931471805599453)
            Mockito.`when`(lnMock(1.0)).thenReturn(0.0)
            Mockito.`when`(lnMock(2.0)).thenReturn(0.6931471805599453)
            Mockito.`when`(lnMock(E)).thenReturn(1.0)
            Mockito.`when`(lnMock(3.5)).thenReturn(1.252762968495368)
            Mockito.`when`(lnMock(5.0)).thenReturn(1.6094379124341003)

            Mockito.`when`(log2Mock(-1.0)).thenThrow(IllegalArgumentException("Аргумент вне ОДЗ"))
            Mockito.`when`(log2Mock(0.0)).thenThrow(IllegalArgumentException("Аргумент вне ОДЗ"))
            Mockito.`when`(log2Mock(0.5)).thenReturn(-1.0)
            Mockito.`when`(log2Mock(1.0)).thenReturn(0.0)
            Mockito.`when`(log2Mock(2.0)).thenReturn(1.0)
            Mockito.`when`(log2Mock(E)).thenReturn(1.442695040889)
            Mockito.`when`(log2Mock(3.5)).thenReturn(1.8073549220576042)
            Mockito.`when`(log2Mock(5.0)).thenReturn(2.3219280949)

            Mockito.`when`(log5Mock(-1.0)).thenThrow(IllegalArgumentException("Аргумент вне ОДЗ"))
            Mockito.`when`(log5Mock(0.0)).thenThrow(IllegalArgumentException("Аргумент вне ОДЗ"))
            Mockito.`when`(log5Mock(0.5)).thenReturn(-0.43067655807)
            Mockito.`when`(log5Mock(1.0)).thenReturn(0.0)
            Mockito.`when`(log5Mock(2.0)).thenReturn(0.43067655807)
            Mockito.`when`(log5Mock(E)).thenReturn(0.62133493456)
            Mockito.`when`(log5Mock(3.5)).thenReturn(0.77838539705)
            Mockito.`when`(log5Mock(5.0)).thenReturn(1.0)
        }
    }

    @Test
    fun `systemFunction(x) test`() {
        val systemFunction = SystemFunction(acc, sinMock, tanMock, cotMock, cscMock, log2Mock, log5Mock)

        Assertions.assertAll(
            { assertFailsWith<java.lang.IllegalArgumentException> { systemFunction(-PI/2) } },
            { assertFailsWith<java.lang.IllegalArgumentException> { systemFunction(-PI) } },
            { assertFailsWith<java.lang.IllegalArgumentException> { systemFunction(0.0) } },
            { Assertions.assertEquals(112.90508007763304, systemFunction(-2.0), acc) },
            { Assertions.assertEquals(7.856176838202663e-4, systemFunction(-0.5), acc) },
            { Assert.assertEquals(Double.NaN, systemFunction(1.0), acc) },
            { Assert.assertEquals(0.456801, systemFunction(2.0), acc) },
            { Assert.assertEquals(0.6153101892926371, systemFunction(E), acc) },
            { Assert.assertEquals(0.763578, systemFunction(3.5), acc) },
            { Assert.assertEquals(1.0, systemFunction(5.0), acc) },
        )
    }

    @Test
    fun `Full integration test`() {
        val systemFunction = SystemFunction(acc)

        Assertions.assertAll(
            { assertFailsWith<java.lang.IllegalArgumentException> { systemFunction(-PI/2) } },
            { assertFailsWith<java.lang.IllegalArgumentException> { systemFunction(-PI) } },
            { assertFailsWith<java.lang.IllegalArgumentException> { systemFunction(0.0) } },
            { Assertions.assertEquals(112.90508007763304, systemFunction(-2.0), acc) },
            { Assertions.assertEquals(7.856176838202663e-4, systemFunction(-0.5), acc) },
            { Assert.assertEquals(2.0523728628809868E-4, systemFunction(-1.0), acc) },
            { assertFailsWith<IllegalArgumentException> { systemFunction(0.0) } },
            { Assert.assertEquals(Double.NaN, systemFunction(1.0), acc) },
            { Assert.assertEquals(0.456801, systemFunction(2.0), acc) },
            { Assert.assertEquals(0.6153101892926371, systemFunction(E), acc) },
            { Assert.assertEquals(0.763578, systemFunction(3.5), acc) },
            { Assert.assertEquals(1.0, systemFunction(5.0), acc) },
        )
    }
}