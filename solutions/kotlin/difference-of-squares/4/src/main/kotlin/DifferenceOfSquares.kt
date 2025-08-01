import java.util.stream.IntStream

private fun Int.squared() = this.times(this)

class Squares(private val number: Int) {

    fun sumOfSquares() = sum(Int::squared)

    fun squareOfSum() = sum { it }.squared()

    fun difference() = squareOfSum() - sumOfSquares()

    private fun sum(modifier: (Int) -> Int):Int = 1.rangeTo(number).sumOf(modifier)
}
