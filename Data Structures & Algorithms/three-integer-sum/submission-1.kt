class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()
        for(i in nums.indices) {
            var firstNum = nums[i]
            if(firstNum > 0) break
            if(i > 0 && nums[i - 1] == firstNum) continue
            
            var l = i + 1
            var r = nums.size - 1
            while(l < r) {
                val threeSum = firstNum + nums[l] + nums[r]
                when {
                    threeSum > 0 -> r--
                    threeSum < 0 -> l++
                    else -> {
                        res.add(listOf(firstNum, nums[l] , nums[r]))
                        r--
                        l++
                        while(l < r && nums[l] == nums[l-1]) l++
                    }
                    
                }
            }
        }
        return res
    }
}
