package unitTests

import org.junit.Assert
import org.junit.jupiter.api.Assertions.assertAll
import trigonometric.*
import java.lang.IllegalArgumentException
import kotlin.math.PI
import kotlin.test.Test
import kotlin.test.assertFailsWith

class TestTrigonometric {

    private val acc = 0.0001

    @Test
    fun `sin(x) test`() {
        val sin = Sin(acc)

        assertAll(
            { Assert.assertEquals(0.0, sin(-PI), acc) },
            { Assert.assertEquals(-1.0, sin(-PI / 2), acc) },
            { Assert.assertEquals(-0.4794255386042, sin(-0.5), acc) },
            { Assert.assertEquals(0.0, sin(0.0), acc) },
            { Assert.assertEquals(1.0, sin(PI / 2), acc) },
            { Assert.assertEquals(0.9757233578266591, sin(1.35), acc) },
            { Assert.assertEquals(0.0, sin(PI), acc) },
            { Assert.assertEquals(0.1326082404856072, sin(-3 * PI - 0.133), acc) },
            { Assert.assertEquals(0.6961352386273582, sin(10 * PI + 0.77), acc) }
        )
    }

    @Test fun `cos(x) test`() {
        val cos = Cos(acc)

        assertAll(
            { Assert.assertEquals(-1.0, cos(-PI), acc) },
            { Assert.assertEquals(0.0, cos(-PI / 2), acc) },
            { Assert.assertEquals(0.8775825618903728, cos(-0.5), acc) },
            { Assert.assertEquals(1.0, cos(0.0), acc) },
            { Assert.assertEquals(0.5403023058681398, cos(1.0), acc) },
            { Assert.assertEquals(0.0, cos(PI / 2), acc) },
            { Assert.assertEquals(-1.0, cos(PI), acc) },
            { Assert.assertEquals(-0.9911685298451073, cos(-3 * PI - 0.133), acc) },
            { Assert.assertEquals(0.7179106696109421, cos(10 * PI + 0.77), acc) }
        )
    }

    @Test fun `cot(x) test`() {
        val cot = Cot(acc)

        assertAll(
            { assertFailsWith<IllegalArgumentException> { cot(PI) } },
            { assertFailsWith<IllegalArgumentException> { cot(-PI) } },
            { assertFailsWith<IllegalArgumentException> { cot(0.0) } },
            { Assert.assertEquals(0.45765755436028577, cot(-2.0), acc) },
            { Assert.assertEquals(0.0, cot(-PI / 2), acc) },
            { Assert.assertEquals(-1.830487721712452, cot(-0.5), acc) },
            { Assert.assertEquals(1.830487721712452, cot(0.5), acc) },
            { Assert.assertEquals(0.0, cot(PI / 2), acc) },
            { Assert.assertEquals(-0.5848478064594647, cot(2.1), acc) }
        )
    }

    @Test fun `tan(x) test`() {
        val tan = Tan(acc)

        assertAll(
            { assertFailsWith<IllegalArgumentException> { tan(-PI/2) } },
            { assertFailsWith<IllegalArgumentException> { tan(PI/2) } },
            { Assert.assertEquals(-14.101419947171719, tan(-1.5), acc) },
            { Assert.assertEquals(0.0, tan(0.0), acc) },
            { Assert.assertEquals(0.5463024898437905, tan(0.5), acc) },
            { Assert.assertEquals(0.0, tan(PI), acc) },
            { Assert.assertEquals(-0.1425465430742778, tan(3.0), acc) },
            { Assert.assertEquals(0.3745856401585947, tan(3.5), acc) }
        )
    }

    @Test fun `csc(x) test`() {
        val csc = Csc(acc)

        assertAll(
            { assertFailsWith<IllegalArgumentException> { csc(-PI) } },
            { assertFailsWith<IllegalArgumentException> { csc(PI) } },
            { assertFailsWith<IllegalArgumentException> { csc(0.0) } },
            { Assert.assertEquals(-7.086167395737187, csc(-3.0), acc) },
            { Assert.assertEquals(-1.0, csc(-PI/2), acc) },
            { Assert.assertEquals(-1.1883951057781212, csc(-1.0), acc) },
            { Assert.assertEquals(2.085829642933488, csc(0.5), acc) },
            { Assert.assertEquals(1.0, csc(PI/2), acc) },
            { Assert.assertEquals(1.0997501702946164, csc(2.0), acc) }
        )
    }
}