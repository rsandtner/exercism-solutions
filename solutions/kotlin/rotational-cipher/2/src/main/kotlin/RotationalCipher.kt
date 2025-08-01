class RotationalCipher(shift: Int) {

    private val cipherMapping = createMapping('a'..'z', shift) + createMapping('A'..'Z', shift)

    fun encode(text: String) = text
        .map { cipherMapping[it] ?: it }
        .joinToString(separator = "")

    private fun createMapping(range: CharRange, shift: Int) =
        range.zip(range.drop(shift) + range.take(shift))
            .toMap()
}
