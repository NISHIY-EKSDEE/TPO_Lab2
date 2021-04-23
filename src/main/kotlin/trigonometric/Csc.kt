package trigonometric

import Function
import kotlin.math.PI
import kotlin.math.abs

class Csc(acc: Double, private val sin: Sin = Sin(acc)) : Function(acc) {

    override fun invoke(x: Double): Double {
        if (abs(x % PI) < acc) {
            throw IllegalArgumentException("Неопределенное значение функции")
        }

        return 1/sin(x)
    }
}