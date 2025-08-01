class Robot {

    companion object {

        private val names = mutableSetOf<String>()

        private fun generateName(): String {

            val name = (1..2).map { generateLetter() }.joinToString("") + generateNumber().toString()
            return if (names.add(name)) name else generateName()
        }

        private fun generateLetter(): Char = ('A'..'Z').random()

        private fun generateNumber(): Int = (100..999).random()
    }


    private var _name: String? = null

    val name: String
        get() {
            _name = _name ?: generateName()
            return _name!!
        }

    fun reset() {
        _name = generateName()
    }

}
