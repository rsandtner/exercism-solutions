private val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
private val lower = upper.lowercase()

class RotationalCipher(private val shift: Int) {

    fun encode(text: String) = text
        .map(::shift)
        .joinToString(separator = "")

    private fun shift(c: Char): Char {

        if (!c.isLetter()) return c

        var seq = upper
        if (c.isLowerCase()) {
            seq = lower
        }

        var index = seq.indexOf(c) + shift
        if (index >= seq.length) {
            index -= seq.length
        }

        return seq[index]
    }
}
