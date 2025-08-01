import java.util.stream.IntStream
import kotlin.math.pow

class Squares(val number: Int) {

    fun sumOfSquares() = sum { square(it) }

    fun squareOfSum() = square(sum { it })

    fun difference() = squareOfSum() - sumOfSquares()

    private fun sum(modifier: (Int) -> Int): Int {
        return IntStream.rangeClosed(1, number)
            .map(modifier)
            .sum()
    }

    private fun square(i: Int) = i.toFloat().pow(2).toInt()
}
