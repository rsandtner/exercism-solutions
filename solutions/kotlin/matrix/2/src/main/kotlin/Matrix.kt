class Matrix(private val matrixAsString: String) {

    fun column(colNr: Int): List<Int> {
        return matrix().map { it[colNr - 1] }
    }

    fun row(rowNr: Int): List<Int> {
        return matrix()[rowNr - 1]
    }

    private fun matrix() = matrixAsString.lines()
        .map { line ->
            line.split(" ")
                .map(String::toInt)
        }
}
