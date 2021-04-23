package trigonometric

import Function
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow


class Sin(acc: Double) : Function(acc) {

    private fun factorial(n: Int) : Long {
        var res : Long = 1
        for (i in 2..n) {
            res *= i
        }
        return res
    }

    override fun invoke(x: Double): Double {
        var x = x % (2 * PI)
        if (x > PI) {
            x -= 2 * PI
        } else {
            if (x < -PI) {
                x += 2 * PI
            }
        }

        val tailorTerm = { n: Int -> ((-1.0).pow(n) * x.pow(2 * n + 1)) / factorial(2 * n + 1) }
        var res = 0.0
        var cur = 0.0
        var prev: Double
        var n = 0

        do {
            prev = cur
            cur = tailorTerm(n)
            res += cur
            n++
        } while (abs(prev - cur) > acc)

        return res
    }
}