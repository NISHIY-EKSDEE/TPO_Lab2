package logarithmic

import Function

class Log2(acc: Double, private val ln: Ln = Ln(acc)) : Function(acc) {

    override fun invoke(x: Double): Double {
        return ln(x)/ln(2.0)
    }
}