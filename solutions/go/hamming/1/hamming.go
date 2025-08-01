package hamming

import "errors"

// Distance calculates the differences between two strings
//
// Only strings with the same length are supported
func Distance(a, b string) (int, error) {

	if len(a) != len(b) {
		return 0, errors.New("strings must be of same length")
	}

	dist := 0
	for i, s := range a {
		if s != rune(b[i]) {
			dist++
		}
	}

	return dist, nil

}
