class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        // Sorting aproach
        //--------------------

        if(hand.size % groupSize != 0) return false

        val map = HashMap<Int, Int>()
        for(num in hand) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        hand.sort()
        for(num in hand) {
            if(map[num]!! > 0) {
                for(i in num until num + groupSize) {
                    if(map.getOrDefault(i, 0) == 0) return false
                    map[i] = map[i]!! - 1
                }
            }
        }
        return true
    }
}
