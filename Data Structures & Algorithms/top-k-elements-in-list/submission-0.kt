class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()

        // iterate the nums array and store the number and frequencies
        // in the map
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        // create an array of pairs containg a number and frequencies for sorting
        val freqList = mutableListOf<Pair<Int, Int>>()

        // lets iterate the map to construct the list
        for ((key, values) in map) {
            freqList.add(Pair(values, key))
        }

        freqList.sortByDescending{it.first}

        val res = IntArray(k)

        for (i in 0 until k) {
            res[i] = freqList.get(i).second
        }

        return res
    }
}
