package proverb

import "fmt"

// Proverb generates a proverbial rhyme of the given input
func Proverb(rhyme []string) []string {

	if len(rhyme) == 0 {
		return []string{}
	}

	res := proverb(rhyme)
	return append(res, fmt.Sprintf("And all for the want of a %s.", rhyme[0]))
}

func proverb(rhyme []string) []string {
	count := len(rhyme)

	var result []string
	if count < 2 {
		return result
	}

	result = append(result, fmt.Sprintf("For want of a %s the %s was lost.", rhyme[0], rhyme[1]))
	result = append(result, proverb(rhyme[1:])...)

	return result
}
