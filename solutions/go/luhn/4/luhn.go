package luhn

import (
	"unicode"
)

// Valid validates the given string using the luhn algorithm
func Valid(s string) bool {

	sum := 0
	count := 0
	doubleIt := false

	for i := len(s) - 1; i >= 0; i-- {

		d := s[i]

		if d == ' ' {
			continue
		}

		if !unicode.IsDigit(rune(d)) {
			return false
		}

		count++

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

	return count > 1 && sum%10 == 0
}
