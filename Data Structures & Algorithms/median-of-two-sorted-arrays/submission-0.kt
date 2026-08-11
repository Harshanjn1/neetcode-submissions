class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        var A = nums1
        var B = nums2
        val total = A.size + B.size
        val half =  (total + 1) / 2

        if(B.size < A.size) {
            A = nums2
            B = nums1
        }

        var l = -1
        var r = A.size - 1
        while(l <= r) {
            val i = l + (r - l) / 2
            val j = half - i - 2

            val ALeft = if(i >= 0) A[i] else Int.MIN_VALUE
            val ARight = if(i + 1 < A.size) A[i+1] else Int.MAX_VALUE
            val BLeft = if(j >= 0) B[j] else Int.MIN_VALUE
            val BRight = if(j + 1 < B.size) B[j+1] else Int.MAX_VALUE

            if(ALeft <= BRight && BLeft <= ARight) {
                if(total % 2 != 0) {
                    return max(ALeft.toDouble(), BLeft.toDouble())
                } else {
                    return (max(ALeft.toDouble(), BLeft.toDouble()) + min(ARight.toDouble(), BRight.toDouble())) / 2
                }
            } else if(ALeft > BRight) {
                r = i -1
            } else {
                l = i + 1
            }
        }

        return -1.0

    }
}
