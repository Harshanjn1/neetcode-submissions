class Twitter {

    private val followMap = HashMap<Int, HashSet<Int>>()
    private val tweetMap = HashMap<Int, MutableList<IntArray>>()
    private var time = 0

    fun postTweet(userId: Int, tweetId: Int) {
        tweetMap.getOrPut(userId){mutableListOf<IntArray>()}.add(intArrayOf(time++, tweetId))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val res = mutableListOf<Int>()
        val maxHeap = PriorityQueue<IntArray>(compareByDescending { it[0] })

        if (!followMap.containsKey(userId)) {
            followMap[userId] = HashSet()
        }
        followMap[userId]?.add(userId)

        followMap[userId]?.forEach{ followeeId ->
            tweetMap[followeeId]?.let { tweets ->
                if(tweets.isNotEmpty()) {
                    val index = tweets.size - 1
                    val (time, tweetId) = tweets[index]
                    maxHeap.add(intArrayOf(time, tweetId, followeeId, index - 1))
                }
            }
        }

        while (maxHeap.isNotEmpty() && res.size < 10) {
            val (count , tweetId, followeeId, index) = maxHeap.poll()
            res.add(tweetId)

            if(index >= 0) {
                val tweets = tweetMap[followeeId]!!
                val (nextCount, nextTweetId) = tweets[index]
                maxHeap.add(intArrayOf(nextCount, nextTweetId, followeeId, index - 1))
            }
        }

        return res
    }

    fun follow(followerId: Int, followeeId: Int) {
        followMap.getOrPut(followerId){HashSet<Int>()}.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followMap[followerId]?.remove(followeeId)
    }
}
