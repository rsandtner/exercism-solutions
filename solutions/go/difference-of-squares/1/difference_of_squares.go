package diffsquares

import "math"

// SquareOfSum calculates the square of the sum of the first given number
func SquareOfSum(n int) int {

	sum := 0
	for i := 1; i <= n; i++ {
		sum += i
	}

	return int(math.Pow(float64(sum), 2))
}

// SumOfSquares calculates the sum of the given first numbers squared
func SumOfSquares(n int) int {

	sum := 0
	for i := 1; i <= n; i++ {
		sum += int(math.Pow(float64(i), 2))
	}

	return sum
}

// Difference returns the difference between the square of sum
// and sum of squares calculated using the first given numbers
func Difference(i int) int {
	return SquareOfSum(i) - SumOfSquares(i)
}

