package main

import (
	"testing"
)

func TestCheckPermutation(t *testing.T) {
	type args struct {
		st1 string
		st2 string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "Test-1",
			args: args{
				st1: "foo",
				st2: "bar",
			},
			want: false,
		},
		{
			name: "Test-2",
			args: args{
				st1: "foo",
				st2: "oof",
			},
			want: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := CheckPermutation(tt.args.st1, tt.args.st2); got != tt.want {
				t.Errorf("CheckPermutation() = %v, want %v", got, tt.want)
			}
		})
	}
}
