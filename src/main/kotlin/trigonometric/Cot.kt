package trigonometric

import Function
import kotlin.math.PI
import kotlin.math.abs

class Cot(acc: Double, private val sin: Sin = Sin(acc), private val cos: Cos = Cos(acc)) : Function(acc) {

    override fun invoke(x: Double): Double {
        if (abs(x % PI) < acc) {
            throw IllegalArgumentException("Неопределенное значение функции")
        }

        return cos(x)/sin(x)
    }
}