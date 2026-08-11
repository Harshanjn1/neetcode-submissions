class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var zeroCount = 0
        var prod = 1

        // iterate the array to find out zero count and product of the array
        for(num in nums) {
            if(num != 0) {
                prod *= num
            } else {
                zeroCount ++
            }
        }

        val res = IntArray(nums.size)

        if(zeroCount > 1) {
            return res
        }


        for(i in 0 until nums.size) {
            res[i] = if(zeroCount > 0) {
                if(nums[i] == 0) prod else 0
            } else {
                prod / nums[i]
            }
        }

        return res
    }
}
