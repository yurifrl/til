package main

func pivotIndex(nums []int) int {

	pivot := 0

	for pivot < len(nums) {
		left := 0
		right := 0

		for i := 0; i < pivot; i++ {
			left += nums[i]
		}

		for i := len(nums) - 1; i > pivot; i-- {
			right += nums[i]
		}

		if left == right {
			return pivot
		}

		pivot++

	}

	return -1
}

// left = 0
// right = 0
// [1,7,3,6,5,6]
//  |            -> 0, 27
//    |          -> 1 ,20
//      |        -> 8 , 17
//        |      -> 11 , 11
// return 3
