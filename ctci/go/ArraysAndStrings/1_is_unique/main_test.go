package main

import "testing"

func TestIsUnique(t *testing.T) {
	type args struct {
		a string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "Test-1",
			args: args{
				a: "foo",
			},
			want: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := IsUnique(tt.args.a); got != tt.want {
				t.Errorf("IsUnique() = %v, want %v", got, tt.want)
			}
		})
	}
}
