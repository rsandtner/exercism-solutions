object WordCount {

    fun phrase(phrase: String) = phrase.splitToSequence(Regex("[^\\w']"))
        .map { it.trim('\'') }
        .filter(String::isNotEmpty)
        .groupingBy(String::lowercase)
        .eachCount()
}
