package main

import (
	"fmt"
	"reflect"
	"strings"
	"testing"
)

func TestExec(t *testing.T) {
	type args struct {
		input string
	}
	testcases := []struct {
		name string
		args args
		want int64
	}{
		{
			name: "Test-1",
			args: args{
				input: "3\n3 2 1\n",
			},
			want: 6,
		},
		{
			name: "Test-2",
			args: args{
				input: "5\n1 2 3 100000 100000\n",
			},
			want: 10000000000,
		},
		{
			name: "Test-3",
			args: args{
				input: "10\n7 5 14 2 8 8 10 1 2 3\n",
			},
			want: 140,
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			input := strings.NewReader(tc.args.input)
			a, b, err := readInput(input)
			if err != nil {
				t.Errorf("read from input error = %v", err)
				return
			}
			got := exec(a, b)
			if !reflect.DeepEqual(got, tc.want) {
				t.Errorf("main exec() got = %v, want %v", got, tc.want)
			}
			fmt.Println(got)
		})
	}
}
