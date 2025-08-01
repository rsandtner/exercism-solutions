package etl

import "strings"

// Transform maps the given data to the new format
func Transform(data map[int][]string) map[string]int {

	mapped := make(map[string]int)

	for k, v := range data {
		for _, s := range v {
			mapped[strings.ToLower(s)] = k
		}
	}

	return mapped
}
