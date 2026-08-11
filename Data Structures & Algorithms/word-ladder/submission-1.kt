class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        if(wordList.contains(endWord).not()) return 0

        val nei = HashMap<String, MutableSet<String>>().withDefault{mutableSetOf()}
        val allwords = wordList.toMutableSet().apply {
            add(beginWord)
        }

        for(word in allwords) {
            for(j in word.indices) {
                val pattern = word.substring(0, j) + "*" + word.substring(j+1)
                nei.getOrPut(pattern){mutableSetOf()}.add(word)
            }
        }

        val visited = HashSet<String>()
        var res = 1
        val queue = ArrayDeque<String>().apply{
            add(beginWord)}
        while(queue.isNotEmpty()) {
            repeat(queue.size) {
                val word = queue.removeFirst()
                if(word == endWord) return res

                for(j in word.indices) {
                    val pattern = word.substring(0, j) + "*" + word.substring(j+1)
                    for(neighbour in nei.getOrDefault(pattern, emptySet())) {
                        if(neighbour !in visited) {
                            queue.addLast(neighbour)
                            visited.add(neighbour)
                        }
                    }
                }
            }
            res++
        }
        return 0
    }
}
