class Robot {

    companion object {

        private val names = mutableSetOf<String>()

        private fun generateName(): String {

            val name =
                (1..2).map { generateLetter() }.joinToString("") +
                        (1..3).map { generateNumber() }.joinToString("")

            return if (names.add(name)) name else generateName()
        }

        private fun generateLetter(): Char = ('A'..'Z').random()

        private fun generateNumber(): Int = (0..9).random()
    }

    private var _name: String? = null

    val name: String
        get() {

            _name ?: run { _name = generateName() }
            return _name!!
        }

    fun reset() {
        _name = null
    }
}
