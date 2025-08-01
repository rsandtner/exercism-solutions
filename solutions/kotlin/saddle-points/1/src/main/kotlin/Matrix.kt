data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(matrix: List<List<Int>>) {

    val saddlePoints: Set<MatrixCoordinate> by lazy {
        calculateSaddlePoints(matrix)
    }

    private fun calculateSaddlePoints(matrix: List<List<Int>>): Set<MatrixCoordinate> {

        return matrix.mapIndexed { row, values ->
            values.mapIndexed { col, value ->

                if (values.maxOrNull() == value &&
                    matrix.minOfOrNull { it[col] } == value
                ) {

                    MatrixCoordinate(row + 1, col + 1)
                } else null
            }
        }
            .flatten()
            .filterNotNull()
            .toSet()
    }
}
