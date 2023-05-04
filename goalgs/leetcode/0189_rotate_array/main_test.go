package main

import (
	"reflect"
	"testing"
)

func Test(t *testing.T) {
	type args struct {
		nums []int
		k    int
	}
	testcases := []struct {
		name string
		args args
		want []int
	}{
		{
			name: "Test-1",
			args: args{
				nums: []int{1, 2, 3, 4, 5, 6, 7},
				k:    3,
			},
			want: []int{5, 6, 7, 1, 2, 3, 4},
		},
		{
			name: "Test-2",
			args: args{
				nums: []int{1, 2},
				k:    3,
			},
			want: []int{2, 1},
		},
		{
			name: "Test-3",
			args: args{
				nums: []int{1, 2},
				k:    3,
			},
			want: []int{2, 1},
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			rotate(tc.args.nums, tc.args.k)
			if !reflect.DeepEqual(tc.args.nums, tc.want) {
				t.Errorf("rotate(): %v, want: %v", tc.args.nums, tc.want)
			}
		})
	}
}
