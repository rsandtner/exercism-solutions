package proverb

import "fmt"

// Proverb generates a proverbial rhyme of the given input
func Proverb (rhyme []string) []string {

	length := len(rhyme)

	sentences := make([]string, length, length)
	if length == 0 {
		return sentences
	}

	for i := 1; i <= length; i++ {

		if i == length {
			sentences[i-1] = fmt.Sprintf("And all for the want of a %s.", rhyme[0])
			continue
		}

		sentences[i-1] = fmt.Sprintf("For want of a %s the %s was lost.", rhyme[i-1], rhyme[i])
	}

	return sentences
}

func ProverbRecursive(rhyme []string) []string {

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

func ProverbRecursiveInitialized(rhyme []string) []string {

	length := len(rhyme)
	sentences := make([]string, length, length)
	if length == 0 {
		return sentences
	}

	proverbInitialized(rhyme, sentences, 0)

	sentences[length-1] = fmt.Sprintf("And all for the want of a %s.", rhyme[0])
	return sentences
}

func proverbInitialized(rhyme, sentences []string, idx int) {

	if len(rhyme) < 2 {
		return
	}

	sentences[idx] = fmt.Sprintf("For want of a %s the %s was lost.", rhyme[0], rhyme[1])
	proverbInitialized(rhyme[1:], sentences, idx+1)
}
