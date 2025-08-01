class Robot {

    private var _name = NameGenerator.generateName()

    val name: String
        get() {
            return _name
        }

    fun reset() {
        _name = NameGenerator.generateName()
    }
}

private object NameGenerator {

    private val names = mutableSetOf<String>()

    tailrec fun generateName(): String {

        val name = generateLetter() + generateNumber()
        return if (names.add(name)) name else generateName()
    }
}

private fun generateLetter() = (1..2).map { ('A'..'Z').random() }.joinToString("")

private fun generateNumber() = (100..999).random()
