package main

import (
	"fmt"
	"io"
	"reflect"
	"strings"
	"testing"
)

func TestExec(t *testing.T) {
	type args struct {
		input string
	}
	testcases := []struct {
		name      string
		args      args
		want      int
		readInput func(r io.Reader) (int, int, error)
		exec      func(a, b int) int
	}{
		{
			name: "Test-1",
			args: args{
				input: "5 5\n",
			},
			want:      10,
			readInput: readTwoNumbers,
			exec:      exec,
		},
		{
			name: "Test-2",
			args: args{
				input: "5 6\n",
			},
			want:      11,
			readInput: readTwoNumbers,
			exec:      exec,
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			input := strings.NewReader(tc.args.input)
			a, b, err := tc.readInput(input)
			if err != nil {
				t.Errorf("read from input error = %v", err)
				return
			}
			got := tc.exec(a, b)
			if !reflect.DeepEqual(got, tc.want) {
				t.Errorf("main exec() got = %v, want %v", got, tc.want)
			}
			fmt.Println(got)
		})
	}
}
