class Solution {
    fun permute(nums: IntArray): List<List<Int>> {

        val res = mutableListOf<List<Int>>()
        fun backTrack(perm: MutableList<Int>, pick: BooleanArray){
            if(perm.size == nums.size) {
                res.add(perm.toList())
                return
            }

            for(i in 0 until nums.size) {
                if(pick[i].not()) {
                    perm.add(nums[i])
                    pick[i] = true

                    backTrack(perm, pick)
                    perm.removeLast()
                    pick[i] = false
                }
            }
        }
        backTrack(mutableListOf<Int>(), BooleanArray(nums.size))
        return res
        // if(nums.isEmpty()) return listOf(listOf())

        // val perms = permute(nums.sliceArray(1 until nums.size))

        // val res = mutableListOf<List<Int>>()
        // for(p in perms) {
        //     for(i in 0..p.size){
        //         val pcopy = p.toMutableList()
        //         pcopy.add(i, nums[0])
        //         res.add(pcopy)
        //     }
        // }
        // return res
    }
}
