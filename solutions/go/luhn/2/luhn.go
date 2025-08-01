package luhn

import (
	"unicode"
)

// Valid validetas the given string as
func Valid(s string) bool {

	sum := 0
	count := 0

	length := len(s)
	for i := length - 1; i >= 0; i-- {

		d := s[i]

		if d == ' ' {
			continue
		}

		if !unicode.IsDigit(rune(d)) {
			return false
		}

		count++

		val := int(d - '0')
		if count%2 == 0 {
			val = val << 1
			if val > 9 {
				val -= 9
			}
		}

		sum += val
	}

	return count > 1 && sum%10 == 0
}
