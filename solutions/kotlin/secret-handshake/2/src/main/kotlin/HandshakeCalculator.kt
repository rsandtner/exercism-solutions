object HandshakeCalculator {

    private const val BINARY_LENGTH = 5

    fun calculateHandshake(number: Int): List<Signal> {

        val binary = Integer.toBinaryString(number)
            .reversed()
            .padEnd(BINARY_LENGTH, '0')

        val signals = binary.take(BINARY_LENGTH - 1)
            .mapIndexedNotNull { i, c -> Signal.values()[i].takeIf { c == '1' } }
            .toList()

        return when(binary.last()) {
            '1' -> signals.reversed()
            else -> signals
        }
    }
}
