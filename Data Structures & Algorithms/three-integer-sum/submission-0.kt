class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        nums.sort()//sort the array to use two pointer approach

        for(i in nums.indices) {
            val value = nums[i]

            // if first element itself is positive in the non-decreasing
            // array then the triplet will never exist
            if(value > 0) break

            if(i > 0 && nums[i -1] == value) continue

            var l = i + 1
            var r = nums.size - 1
            
            while(l < r) {

                val sum = value + nums[l]+nums[r]
                if(sum == 0) {
                    res.add(mutableListOf(value, nums[l], nums[r]))
                    l++ 
                    r--

                    while(l < r && nums[l] == nums[l-1]) {
                        l++
                    }
                } else if(sum < 0) {
                    l++
                } else {
                    r--
                }
            }

        }

        return res
    }
}
