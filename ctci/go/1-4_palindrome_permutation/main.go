package main

import (
	"unicode"

	"github.com/k0kubun/pp/v3"
)

var _ = pp.Println

// Palindrome Permutation
// Given a string, write a function to check if it is a permutation of a palin­drome.
// A palindrome is a word or phrase that is the same forwards and backwards.
// A permutation is a rearrangement of letters.
// The palindrome does not need to be limited to just dictionary words.
// EXAMPLE
// Input: Tact Coa
// Output: True (permutations: "taco cat", "atco eta", etc.)
func PalindromePermutation(entry string) bool {
	odd := 0
	h := make(map[rune]int)
	for _, c := range entry {
		c = unicode.ToLower(c)
		if !unicode.IsLetter(c) {
			continue
		}
		h[c] += 1

		if h[c]%2 == 0 {
			odd--
		} else {
			odd++
		}

	}
	return odd <= 1
}
