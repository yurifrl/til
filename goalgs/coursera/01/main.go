package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

// readTwoNumbers reads two numbers from the input and returns them.
func readTwoNumbers(r io.Reader) (int, int, error) {
	reader := bufio.NewReader(r)
	line, err := reader.ReadString('\n')
	if err != nil {
		return 0, 0, err
	}

	parts := strings.Fields(line)
	if len(parts) != 2 {
		return 0, 0, fmt.Errorf("expected 2 numbers, got %d", len(parts))
	}

	a, err := strconv.Atoi(parts[0])
	if err != nil {
		return 0, 0, fmt.Errorf("failed to parse first number: %v", err)
	}

	b, err := strconv.Atoi(parts[1])
	if err != nil {
		return 0, 0, fmt.Errorf("failed to parse second number: %v", err)
	}

	return a, b, nil
}

// exec takes two integers and returns their sum.
func exec(a, b int) int {
	return a + b
}

func main() {
	a, b, err := readTwoNumbers(os.Stdin)
	if err != nil {
		fmt.Printf("Error: %v\n", err)
		return
	}

	result := exec(a, b)
	fmt.Print(result)
}
