package system

import Function
import logarithmic.Log2
import logarithmic.Log5
import kotlin.math.pow
import trigonometric.*

class SystemFunction(acc: Double,
                     private val sin: Sin = Sin(acc),
                     private val tan: Tan = Tan(acc),
                     private val cot: Cot = Cot(acc),
                     private val csc: Csc = Csc(acc),
                     private val log2: Log2 = Log2(acc),
                     private val log5: Log5 = Log5(acc),
                    ) : Function(acc) {

    override fun invoke(x: Double): Double {
        return if (x > 0.0) {
            (((((log5(x) * log5(x)) - log5(x)) / log2(x)) - log5(x)).pow(2))
        } else {
            ((((((cot(x) + csc(x)) - tan(x)) * sin(x)) - (cot(x) / (tan(x) + sin(x)))).pow(3)) / (cot(x).pow(3)))
        }
    }
}