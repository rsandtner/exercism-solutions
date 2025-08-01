package romannumerals

import (
	"fmt"
)

type roman struct {
	r   string
	val int
}

func ToRomanNumeral(i int) (string, error) {

	if i <= 0 || i > 3000 {
		return "", fmt.Errorf("only numbers between 1 and 3000 are supported")
	}

	romans := []roman{
		{"M", 1000},
		{"CM", 900},
		{"D", 500},
		{"CD", 400},
		{"C", 100},
		{"XC", 90},
		{"L", 50},
		{"XL", 40},
		{"X", 10},
		{"IX", 9},
		{"V", 5},
		{"IV", 4},
		{"I", 1},
	}

	return convert(i, romans), nil
}

func convert(i int, romans []roman) string {

	if i == 0 {
		return ""
	}

	var roman roman
	for _, r := range romans {
		if i >= r.val {
			roman = r
			break
		}
	}

	return roman.r + convert(i - roman.val, romans)
}
