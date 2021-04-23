abstract class Function(val acc: Double = 0.0001) {

    init {
        if (acc <= 0) {
            throw IllegalArgumentException("Некорректное значение точности")
        }
    }

    abstract operator fun invoke(x: Double): Double
}