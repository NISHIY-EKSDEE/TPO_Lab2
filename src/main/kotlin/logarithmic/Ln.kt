package logarithmic

import Function
import kotlin.math.abs
import kotlin.math.pow

class Ln(acc: Double) : Function(acc) {

    override fun invoke(x: Double): Double {
        if  (x <= 0.0) {
            throw IllegalArgumentException("Аргумент вне ОДЗ")
        }

        val prefAcc = acc * 0.1
        var tailorTerm = { n: Int -> (x - 1).pow(n) / (n * x.pow(n)) }

        var res = 0.0
        var cur = 0.0
        var prev: Double
        var n = 1
        do {
            prev = cur
            cur = tailorTerm(n)
            res += cur
            n++
        } while(abs(prev - cur) > prefAcc)

        return res
    }
}