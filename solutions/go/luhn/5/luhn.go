package luhn

import (
	"strings"
	"unicode"
)

// Valid validates the given string using the luhn algorithm
func Valid(s string) bool {

	sum := 0
	doubleIt := false

	cleaned := strings.ReplaceAll(s, " ", "")
	length := len(cleaned)
	if length < 2 {
		return false
	}

	for i := length - 1; i >= 0; i-- {

		d := cleaned[i]

		if !unicode.IsDigit(rune(d)) {
			return false
		}

		val := int(d - '0')
		if doubleIt {
			val = val << 1
			if val > 9 {
				val -= 9
			}
		}

		sum += val
		doubleIt = !doubleIt
	}

	return sum%10 == 0
}
