class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    val isEquilateral = a == b && b == c

    val isIsosceles = a == b || b == c || a == c

    val isScalene = !isEquilateral && !isIsosceles

    init {
        val sides = listOf(a, b, c)
            .map { it.toDouble() }
            .sorted()

        require(sides.all { it > 0 }) { "All sides must be greater than 0" }
        require(sides[0] + sides[1] >= sides[2]) { "Triangle inequality violation" }
    }

}
