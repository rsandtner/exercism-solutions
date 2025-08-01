data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(matrix: List<List<Int>>) {

    val saddlePoints = matrix.mapIndexed { row, values ->
        values.mapIndexed { col, value ->

            value.takeIf { values.maxOrNull() == value && matrix.minOfOrNull { it[col] } == value }
                ?.let { MatrixCoordinate(row + 1, col + 1) }
        }
    }
        .flatten()
        .filterNotNull()
        .toSet()
}
