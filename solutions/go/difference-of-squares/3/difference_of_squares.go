package diffsquares

// SquareOfSum calculates the square of the sum of the first given number
func SquareOfSum(n int) int {
	return n * n * (n+1) * (n+1) / 4
}

// SumOfSquares calculates the sum of the given first numbers squared
func SumOfSquares(n int) int {
	return n * (n +1) * (2 * n +1) / 6
}

// Difference returns the difference between the square of sum
// and sum of squares calculated using the first given numbers
func Difference(i int) int {
	return SquareOfSum(i) - SumOfSquares(i)
}

