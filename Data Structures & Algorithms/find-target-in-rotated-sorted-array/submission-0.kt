class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while(l <= r) {
            val mid = l + (r - l) / 2
            if(nums[mid] == target) {
                return mid
            }

            if(nums[l] <= nums[mid]) {
                // left array is sorted
                if (target < nums[l] || target > nums[mid]) {
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            } else {
                // search in right array
                if(target < nums[mid] || target > nums[r]) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            }
        }

        return -1
    }
}
