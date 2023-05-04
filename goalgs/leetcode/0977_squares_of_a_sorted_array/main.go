package main

import "math"

func sortedSquares(nums []int) (result []int) {
	result = make([]int, len(nums))
	left, rigth := 0, len(nums)-1
	var square int

	for i := len(nums) - 1; i >= 0; i-- {
		if math.Abs(float64(nums[left])) > math.Abs(float64(nums[rigth])) {
			square = nums[left]
			left++
		} else {
			square = nums[rigth]
			rigth--
		}
		result[i] = square * square
	}

	return
}
