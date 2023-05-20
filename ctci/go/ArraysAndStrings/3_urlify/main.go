package main

import (
	"github.com/k0kubun/pp/v3"
)

var _ = pp.Println

// Write a method to replace all spaces in a string with '%20'. You may
// assume that the string has sufficient space at the end to hold the additional
// characters,and that you are given the "true" length of the string. (Note: If
// implementing in Java,please use a character array so that you can perform this
// operation in place.)
//
// EXAMPLE
// Input: "Mr John Smith ", 13
// Output: "Mr%20John%20Smith"
func Urlify(entry string, n int) string {
	input := []rune(entry)
	spaceCount := 0
	for i := 0; i < n; i++ {
		if input[i] == ' ' {
			spaceCount++
		}
	}

	output := make([]rune, n+(spaceCount*2))
	outputi := 0
	for i := 0; i < n; i++ {
		if input[i] == ' ' {
			output[outputi] = '%'
			output[outputi+1] = '2'
			output[outputi+2] = '0'
			outputi += 3
		} else {
			output[outputi] = input[i]
			outputi++
		}
	}
	return string(output)
}
