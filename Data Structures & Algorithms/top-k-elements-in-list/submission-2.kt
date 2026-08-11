class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        // soultion 3: using bucket sort
        val map = HashMap<Int, Int>()

        // iterate the nums array and store the number and frequencies
        // in the map
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val freqBucket = List(nums.size + 1) {mutableListOf<Int>()}

        for((key , value) in map) {
            freqBucket[value].add(key)
        }

        val res = mutableListOf<Int>()
        for(i in freqBucket.size - 1 downTo 1) {
            for(num in freqBucket[i]) {
                res.add(num)
            }

            if(res.size == k) {
                return res.toIntArray()
            }
        }
        return res.toIntArray()



        // solution 2 using min heap
        // val map = HashMap<Int, Int>()

        // // iterate the nums array and store the number and frequencies
        // // in the map
        // for (num in nums) {
        //     map[num] = map.getOrDefault(num, 0) + 1
        // }

        // val heap = PriorityQueue<Pair<Int, Int>>(compareBy{it.first})

        // for((key , value ) in map) {
        //     heap.add(Pair(value , key))

        //     if(heap.size > k) {
        //         heap.poll()
        //     }
        // }

        // val res= IntArray(k)

        // for(i in k - 1 downTo 0) {
        //     res[i] = heap.poll().second
        // }

        // return res

        // time complexity = nlogk
        // space complexity = n



        // val map = HashMap<Int, Int>()

        // // iterate the nums array and store the number and frequencies
        // // in the map
        // for (num in nums) {
        //     map[num] = map.getOrDefault(num, 0) + 1
        // }

        // // create an array of pairs containg a number and frequencies for sorting
        // val freqList = mutableListOf<Pair<Int, Int>>()

        // // lets iterate the map to construct the list
        // for ((key, values) in map) {
        //     freqList.add(Pair(values, key))
        // }

        // freqList.sortByDescending{it.first}

        // val res = IntArray(k)

        // for (i in 0 until k) {
        //     res[i] = freqList.get(i).second
        // }

        // return res

        // time complexity = nlogn
        // space complexity = n
    }
}
