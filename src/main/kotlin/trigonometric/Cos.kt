package trigonometric

import Function
import kotlin.math.PI

class Cos(acc: Double, private val sin: Sin = Sin(acc)) : Function(acc) {

    override fun invoke(x: Double): Double {
        return sin(x + PI/2)
    }
}