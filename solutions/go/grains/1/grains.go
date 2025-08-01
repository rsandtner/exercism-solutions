package grains

import "errors"

// Square calculates the number of grains with the
// number of grains doubling on each successive square.
func Square(i int) (uint64, error) {

	if i < 1 || i > 64 {
		return 0, errors.New("i must be in the range between 1 to 64")
	}

	return 1 << (i - 1), nil
}

// Total calculates the total number of grains on a chessboard.
func Total() uint64 {
	return 1<<64 - 1
}
