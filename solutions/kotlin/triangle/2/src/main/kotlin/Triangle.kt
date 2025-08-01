class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    val isEquilateral by lazy { a == b && b == c }

    val isIsosceles by lazy { a == b || b == c || a == c }

    val isScalene by lazy { !isEquilateral && !isIsosceles }

    init {
        val sides = listOf(a, b, c)
            .map { it.toDouble() }
            .sorted()

        require(sides.all { it > 0 }) { "All sides must be greater than 0" }
        require(sides[0] + sides[1] >= sides[2]) { "Triangle inequality violation" }
    }

}
