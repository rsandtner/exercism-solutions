package triangle

import "math"

// Kind of a triangle
type Kind int

const (

	// not a triangle
	NaT = iota

	// equilateral
	Equ

	// isosceles
	Iso

	// scalene
	Sca
)

// KindFromSides calculates the type of the given values.
func KindFromSides(a, b, c float64) Kind {

	if !validSide(a) || !validSide(b) || !validSide(c) || !validateInquality(a, b, c) {
		return NaT
	}

	if a == b && a == c {
		return Equ
	}

	if a == b || a == c || b == c {
		return Iso
	}

	return Sca
}

func validSide(f float64) bool {
	return f > 0 && !math.IsNaN(f) && !math.IsInf(f, 1) && !math.IsInf(f, -1)
}

func validateInquality(a, b, c float64) bool {
	if a+b < c {
		return false
	}

	if a+c < b {
		return false
	}

	return b+c >= a
}
