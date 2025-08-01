package luhn

import (
	"strings"
	"unicode"
)

// Valid validates the given string using the luhn algorithm
func Valid(s string) bool {

	sum := 0

	cleaned := strings.ReplaceAll(s, " ", "")
	if len(cleaned) < 2 {
		return false
	}

	doubleIt := len(cleaned) % 2 == 0

	for _, c := range cleaned {

		if !unicode.IsDigit(c) {
			return false
		}

		val := int(c - '0')
		if doubleIt {
			val *= 2
			if val > 9 {
				val -= 9
			}
		}

		sum += val
		doubleIt = !doubleIt
	}

	return sum%10 == 0
}
