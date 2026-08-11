class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        // Bellman-ford algorithm

        val prices = IntArray(n) {Int.MAX_VALUE}
        prices[src] = 0

        repeat(k + 1) {
            val temp = prices.copyOf()

            for((s, d, c) in flights) {
                if(prices[s] == Int.MAX_VALUE) continue

                if(prices[s] + c < temp[d]) {
                    temp[d] = prices[s] + c
                }
            }
            temp.copyInto(prices)
        }

        return if(prices[dst] != Int.MAX_VALUE) prices[dst] else -1
    }
}
