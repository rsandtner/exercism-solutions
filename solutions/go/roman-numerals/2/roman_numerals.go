package romannumerals

import (
	"bytes"
	"fmt"
)

type roman struct {
	r   string
	val int
}

var romans = []roman{
	roman{"M", 1000},
	roman{"CM", 900},
	roman{"D", 500},
	roman{"CD", 400},
	roman{"C", 100},
	roman{"XC", 90},
	roman{"L", 50},
	roman{"XL", 40},
	roman{"X", 10},
	roman{"IX", 9},
	roman{"V", 5},
	roman{"IV", 4},
	roman{"I", 1},
}

func ToRomanNumeral(i int) (string, error) {

	if i <= 0 || i > 3000 {
		return "", fmt.Errorf("only numbers between 1 and 3000 are supported")
	}

	s := bytes.NewBufferString("")
	n := i
	for n > 0 {

		for _, r := range romans {
			if n >= r.val {
				if _, err := s.WriteString(r.r); err != nil {
					return "", err
				}

				n -= r.val

				break
			}
		}
	}

	return s.String(), nil

}

func ToRomanNumeralRecursive(i int) (string, error) {

	if i <= 0 || i > 3000 {
		return "", fmt.Errorf("only numbers between 1 and 3000 are supported")
	}

	buf := bytes.NewBufferString("")

	convert(i, buf, romans)

	return buf.String(), nil
}

func convert(i int, buf *bytes.Buffer, romans []roman) {

	if i == 0 {
		return
	}

	var roman roman
	for _, r := range romans {
		if i >= r.val {
			roman = r
			break
		}
	}

	buf.WriteString(roman.r)
	convert(i-roman.val, buf, romans)
}
