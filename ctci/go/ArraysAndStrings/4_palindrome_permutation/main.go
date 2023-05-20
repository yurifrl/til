package main

import (
	"unicode"

	"github.com/k0kubun/pp/v3"
)

var _ = pp.Println

// Palindrome Permutation
//
// Given a string, write a function to check if it is a permutation of a palin­drome.
// A palindrome is a word or phrase that is the same forwards and backwards.
// A permutation is a rearrangement of letters.
// The palindrome does not need to be limited to just dictionary words.
//
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

// This function uses bitwise operations to efficiently track
// the characters in the string.
func PalindromePermutation2(entry string) bool {
	// bitVector is an int32 where each bit represents a character in the alphabet.
	// If a bit is set (1), it means that character has appeared an odd number of times.
	var bitVector int32 = 0

	// Iterate over every character in the input string.
	for _, r := range entry {
		// Skip the current character if it is not a letter.
		if !unicode.IsLetter(r) {
			continue
		}

		// Convert the character to lowercase to handle case-insensitivity.
		r = unicode.ToLower(r)

		// Calculate the position of the character in the alphabet (0-based).
		// This is done by subtracting the ASCII value of 'a' from the current character.
		charAlphabetPos := int32(r - 'a')

		// Create a mask with the bit set at the position corresponding to the current character.
		// This is done by shifting 1 to the left by charAlphabetPos positions.
		mask := int32(1 << charAlphabetPos)

		// Check if the bit in bitVector at the position corresponding to the current character is set.
		if (bitVector & mask) == 0 {
			// If the bit is not set, set it using the bitwise OR operation (|=).
			// |= sets a bit to 1 if it was 0.
			bitVector |= mask
		} else {
			// If the bit is set, unset it using the bitwise AND operation (&=) with the
			// bitwise complement of mask (^mask). ^mask flips all bits in mask.
			// &= sets a bit to 0 if it was 1.
			bitVector &= ^mask
		}
	}

	// At this point, bitVector represents the character counts of the string.
	// If the string is a permutation of a palindrome, bitVector can have at most
	// one bit set (indicating at most one character has an odd count).
	// The condition bitVector & (bitVector - 1) == 0 checks if at most one bit is set.
	return bitVector == 0 || (bitVector&(bitVector-1)) == 0
}
