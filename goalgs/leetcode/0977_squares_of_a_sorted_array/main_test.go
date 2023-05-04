package main

import (
	"reflect"
	"testing"
)

func Test(t *testing.T) {
	type args struct {
		nums []int
	}
	testcases := []struct {
		name string
		args args
		want []int
	}{
		{
			name: "Test-1",
			args: args{
				nums: []int{-4, -1, 0, 3, 10},
			},
			want: []int{0, 1, 9, 16, 100},
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			if got := sortedSquares(tc.args.nums); !reflect.DeepEqual(got, tc.want) {
				t.Errorf("sortedSquares() = %v, want %v", got, tc.want)
			}
		})
	}
}
