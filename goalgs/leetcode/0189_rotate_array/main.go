package main

/*
| . | . | index           | ......... |
| . | . | [0,1,2,3,4,5,6] | ......... |
| . | . | len(nums)	 	  | ......... |
| . | . | 7				  | ......... |

| i | k | nums            | result 			|
| 6 | 3 | [1,2,3,4,5,6,7] | [7] 			|
| 5 |   |  				  | [6,7]			|
| 4 |   |  				  | [5,6,7]			|
| 0 |   |  				  | [5,6,7,1]		|
| 1 |   |  				  | [5,6,7,1,2]		|
| 2 |   |  				  | [5,6,7,1,2,3]	|
| 3 |   |  				  | [5,6,7,1,2,3,4]	|



*/

func rotate(nums []int, k int) {
	result := make([]int, len(nums))
	right := len(nums) - k
	count := 0

	if k > len(nums) {
		return
	}

	for i := 0; k > count; i++ {
		result[i] = nums[right]
		right++
		count++
	}

	for i := 0; i < len(nums)-k; i++ {
		result[count] = nums[i]
		count++
	}

	copy(nums, result)
}
