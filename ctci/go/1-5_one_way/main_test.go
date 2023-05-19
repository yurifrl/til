package main

import "testing"

func TestOneWay(t *testing.T) {
	type args struct {
		entry1 string
		entry2 string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "Test-1",
			args: args{
				entry1: "pale",
				entry2: "ple",
			},
			want: true,
		},
		{
			name: "Test-2",
			args: args{
				entry1: "pales",
				entry2: "pale",
			},
			want: true,
		},
		{
			name: "Test-4",
			args: args{
				entry1: "pale",
				entry2: "bale",
			},
			want: true,
		},
		{
			name: "Test-5",
			args: args{
				entry1: "pale",
				entry2: "bae",
			},
			want: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := OneWay(tt.args.entry1, tt.args.entry2); got != tt.want {
				t.Errorf("OneWay() = %v, want %v", got, tt.want)
			}
		})
	}
}
