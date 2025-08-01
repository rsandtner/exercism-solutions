object HandshakeCalculator {

    private const val BINARY_LENGTH = 5

    fun calculateHandshake(number: Int): List<Signal> {

        val binary = Integer.toBinaryString(number)
            .reversed()
            .padEnd(BINARY_LENGTH, '0')

        val signals = binary.take(BINARY_LENGTH - 1)
            .mapIndexed { i, c -> if (c == '1') Signal.values()[i] else null }
            .filterNotNull()
            .toList()

        return when(binary.last()) {
            '1' -> signals.reversed()
            else -> signals
        }
    }
}
