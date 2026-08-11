class Solution {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        val set = HashSet<Int>()

        for(t in triplets) {
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue

            for((index, value) in t.withIndex()) {
                if(value == target[index]) set.add(index)
            }
        }

        return set.size == 3
    }
}
