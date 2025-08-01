class Matrix(private val matrixAsString: String) {

    private val matrix by lazy {
        println("lazy matrix")
        matrixAsString.lines()
            .map { line ->
                line.split(" ")
                    .map(String::toInt)
            }
    }

    fun column(colNr: Int) = matrix.map { it[colNr - 1] }

    fun row(rowNr: Int) = matrix[rowNr - 1]

}
