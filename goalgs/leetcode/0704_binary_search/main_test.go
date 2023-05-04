package main

import (
	"testing"
)

func Test(t *testing.T) {
	type args struct {
		nums   []int
		target int
	}
	testcases := []struct {
		name string
		args args
		want int
	}{
		{
			name: "Test-1",
			args: args{
				nums:   []int{-1, 0, 3, 5, 9, 12},
				target: 9,
			},
			want: 4,
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			if got := search(tc.args.nums, tc.args.target); got != tc.want {
				t.Errorf("search() = %v, want %v", got, tc.want)
			}
		})
	}
}
