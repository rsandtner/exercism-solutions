object ScrabbleScore {

    val scores = mapOf(
        1 to arrayOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'),
        2 to arrayOf('D', 'G'),
        3 to arrayOf('B', 'C', 'M', 'P'),
        4 to arrayOf('F', 'H', 'V', 'W', 'Y'),
        5 to arrayOf('K'),
        8 to arrayOf('J', 'X'),
        10 to arrayOf('Q', 'Z')
    )

    fun scoreLetter(c: Char): Int {
        return scores
            .filter { it.value.contains(c.uppercaseChar()) }
            .map { it.key }
            .first()
    }

    fun scoreWord(word: String): Int {
        return word
            .map { scoreLetter(it) }
            .sum()
    }
}
