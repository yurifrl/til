package main

import (
	"github.com/k0kubun/pp/v3"
)

var _ = pp.Println

// One Away
//
// There are three types of edits that can be performed on strings:
// insert, remove or replace a character.
// Given two strings, write a function to check if they are one edit (or zero edits) away.
//
// EXAMPLE
// pale, ple -> true
// pales, pale -> true
// pale, bale -> true
// pale, bae -> false
func OneWay(entry1 string, entry2 string) bool {
	// a array of e entry 1
	sei := []rune(entry1)
	sej := []rune(entry2)
	a := make(map[rune]int, len(entry1))
	// insert := false
	// remove := false
	// replace := false

	mismatchCount := 0
	for i, j := 0, 0; i < len(sei); {
		if sei[i] != sej[j] {
			mismatchCount++
		}
		if mismatchCount > 1 {
			return false
		}
		if i < len(sei) {
			i++
		}
		if j < len(sej) && mismatchCount != 1 {
			j++
		}

	}

	for i := range sei {
		a[sei[i]]++
		if i < len(sej) {
			a[sej[i]]++
		}
	}

	for k, v := range a {
		pp.Println(string(k), v)
	}

	// replace
	difCount := 0
	for _, v := range a {
		// if the characters that differ are more then one than it cannot be replac
		if v == 1 {
			difCount++
		}
		if difCount > 1 {
			return false
		}
	}
	// insert delete

	return true
}
