class Matrix(private val matrixAsString: String) {

    fun column(colNr: Int) = matrix().map { it[colNr - 1] }

    fun row(rowNr: Int) = matrix()[rowNr - 1]

    private fun matrix() = matrixAsString.lines()
        .map { line ->
            line.split(" ")
                .map(String::toInt)
        }
}
