package isogram

import "unicode"

// IsIsogram returns true if the given word is an isogram ignoring case.
//
// it only checks for duplicated letters and ignores digits and
// all other characters.
func IsIsogram(s string) bool {

	m := make(map[rune]struct{})
	for _, l := range s {

		// only check letters
		if !unicode.IsLetter(l) {
			continue
		}

		upper := unicode.ToUpper(l)

		if _, ok := m[upper]; ok {
			return false
		}

		m[upper] = struct{}{}
	}

	return true
}
