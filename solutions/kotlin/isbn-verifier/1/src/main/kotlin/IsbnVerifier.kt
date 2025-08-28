class IsbnVerifier {

    fun isValid(number: String): Boolean {
        // Normalize by removing dashes; other characters must be validated explicitly
        val normalized = number.replace("-", "")
        if (normalized.length != ISBN_LENGTH) return false

        val body = normalized.dropLast(1)
        if (!body.all { it.isDigit() }) return false

        val checkValue = when (val check = normalized.last()) {
            in '0'..'9' -> check.digitToInt()
            'X' -> 10
            else -> return false
        }

        val sum = body
            .withIndex()
            .sumOf { (index, c) ->
                c.digitToInt() * (10 - index)
            } + checkValue

        return sum % 11 == 0
    }

    private companion object {
        const val ISBN_LENGTH = 10
    }
}
