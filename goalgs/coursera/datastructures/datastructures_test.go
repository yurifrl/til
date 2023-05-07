package main

import (
	"fmt"
	"reflect"
	"testing"
)

func TestQuickSort(t *testing.T) {

	type args struct {
		n   int
		arr []int64
	}
	testcases := []struct {
		name string
		args args
		want []int64
	}{
		{
			name: "Test-1",
			args: args{
				n:   3,
				arr: []int64{3, 2, 1},
			},
			want: []int64{1, 2, 3},
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			got := tc.args.arr
			QuickSort(got, 0, tc.args.n-1)
			if !reflect.DeepEqual(got, tc.want) {
				t.Errorf("main exec() got = %v, want %v", got, tc.want)
			}
			fmt.Println(got)
		})
	}
}
