object ScrabbleScore {

    private val scores = mapOf(
        1 to arrayOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'),
        2 to arrayOf('D', 'G'),
        3 to arrayOf('B', 'C', 'M', 'P'),
        4 to arrayOf('F', 'H', 'V', 'W', 'Y'),
        5 to arrayOf('K'),
        8 to arrayOf('J', 'X'),
        10 to arrayOf('Q', 'Z')
    ).flatMap { entry -> entry.value.map { it to entry.key } }
        .toMap()
        .withDefault { 0 }

    fun scoreLetter(c: Char) = scores.getValue(c.uppercaseChar())

    fun scoreWord(word: String) = word.sumOf { scoreLetter(it) }
}
