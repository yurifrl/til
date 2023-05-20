package main

import (
	"testing"
)

type args struct {
	entry string
}

var tests = []struct {
	name string
	args args
	want bool
}{
	{
		name: "taco cat",
		args: args{entry: "taco cat"},
		want: true,
	},
}

func TestPalindromePermutation(t *testing.T) {
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := PalindromePermutation(tt.args.entry); got != tt.want {
				t.Errorf("PalindromePermutation() = %v, want %v", got, tt.want)
			}
		})
	}
}

func TestPalindromePermutation2(t *testing.T) {
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := PalindromePermutation2(tt.args.entry); got != tt.want {
				t.Errorf("PalindromePermutation2() = %v, want %v", got, tt.want)
			}
		})
	}
}
