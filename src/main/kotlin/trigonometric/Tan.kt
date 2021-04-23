package trigonometric

import Function
import kotlin.math.PI
import kotlin.math.abs

class Tan(acc: Double, private val sin: Sin = Sin(acc), private val cos: Cos = Cos(acc)) : Function(acc) {

    override fun invoke(x: Double): Double {
        if (abs(abs(x % PI) - PI/2) < acc) {
            throw IllegalArgumentException("Неопределенное значение функции")
        }

        return sin(x)/cos(x)
    }
}