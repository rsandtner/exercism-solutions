class Matrix(private val matrixAsString: String) {

    fun column(colNr: Int): List<Int> {
        return matrixAsString.split("\n")
            .map { it.split(" ") }
            .map { it[colNr - 1] }
            .map(String::toInt)
    }

    fun row(rowNr: Int): List<Int> {
        return matrixAsString.split("\n")[rowNr - 1]
            .split(" ")
            .map(String::toInt)
    }
}
