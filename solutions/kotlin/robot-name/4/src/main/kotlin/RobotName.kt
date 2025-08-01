class Robot {

    private var _name: String = generateName()

    val name: String
        get() {
            return _name
        }

    fun reset() {
        _name = generateName()
    }

    companion object {

        private val names = mutableSetOf<String>()

        private tailrec fun generateName(): String {

            val name = generateLetter() + generateNumber()
            return if (names.add(name)) name else generateName()
        }
    }
}

private fun generateLetter(): String = (1..2).map { ('A'..'Z').random() }.joinToString("")

private fun generateNumber(): Int = (100..999).random()
