package main

import "testing"

func TestPalindromePermutation(t *testing.T) {
	type args struct {
		entry string
	}
	tests := []struct {
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
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := PalindromePermutation(tt.args.entry); got != tt.want {
				t.Errorf("PalindromePermutation() = %v, want %v", got, tt.want)
			}
		})
	}
}
