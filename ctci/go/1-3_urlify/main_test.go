package main

import "testing"

func TestUrilfy(t *testing.T) {
	type args struct {
		a string
		n int
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{
			name: "Test-1",
			args: args{
				a: "Mr John Smith ",
				n: 13,
			},
			want: "Mr%20John%20Smith",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := Urlify(tt.args.a, tt.args.n); got != tt.want {
				t.Errorf("Urilfy() = %v, want %v", got, tt.want)
			}
		})
	}
}
