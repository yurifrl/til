package main

func runningSum(nums []int) []int {
	prev := 0
	current := 1

	if len(nums) < 1 {
		return nums
	}

	for current < len(nums) {
		nums[current] = nums[current] + nums[prev]
		current++
		prev++
	}
	return nums
}
