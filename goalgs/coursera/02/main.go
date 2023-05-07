package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

func readInput(r io.Reader) (int, []int64, error) {
	scanner := bufio.NewScanner(r)

	scanner.Scan()
	n, err := strconv.Atoi(scanner.Text())
	if err != nil {
		return 0, nil, err
	}

	scanner.Scan()
	sequenceStr := strings.Split(scanner.Text(), " ")
	sequence := make([]int64, n)

	for i, str := range sequenceStr {
		num, err := strconv.ParseInt(str, 10, 64)
		if err != nil || num < 0 {
			return 0, nil, err
		}
		sequence[i] = num
	}

	return n, sequence, nil
}

// Input: An integer n and a sequence of n non-negative integers.
// Output: Get maximum value that can be obtained by multiplying two different elements from
// the sequence.
func exec(n int, arr []int64) int64 {
	index1 := 0
	for i := 0; i < n; i++ {
		if arr[i] > arr[index1] {
			index1 = i
		}
	}

	index2 := 0

	if index1 == 0 {
		index2 = 1
	}

	for i := 0; i < n; i++ {
		if i != index1 && arr[i] > arr[index2] {
			index2 = i
		}
	}

	return arr[index1] * arr[index2]
}

// Maximum Pairwise Product
func main() {
	a, b, err := readInput(os.Stdin)
	if err != nil {
		panic(err)
	}

	result := exec(a, b)
	fmt.Print(result)
}
