object WordCount {

    fun phrase(phrase: String) = phrase.splitToSequence(Regex("[^a-zA-Z0-9']"))
        .map { it.trim('\'') }
        .filter(String::isNotEmpty)
        .map(String::lowercase)
        .groupingBy { it }
        .eachCount()
}
