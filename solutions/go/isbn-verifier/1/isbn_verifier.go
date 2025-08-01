package isbn

import (
	"strings"
	"unicode"
)

func IsValidISBN(isbn string) bool {

	s := strings.ReplaceAll(isbn, "-", "")
	if len(s) != 10 {
		return false
	}

	sum := 0
	for i, c := range s {

		if i < 9 && !unicode.IsDigit(c) {
			return false
		}

		val := int(c - '0')
		if c == 'X' {
			val = 10
		}

		sum += val * (10 - i)
	}

	return sum%11 == 0
}
