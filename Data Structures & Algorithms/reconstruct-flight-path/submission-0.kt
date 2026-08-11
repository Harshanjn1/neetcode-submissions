class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val adjList = HashMap<String, MutableList<String>>()

        // build the adjacency list using the input
        tickets.sortedBy{it[1]}.forEach { (src, dest) ->
            adjList.getOrPut(src) {
                mutableListOf<String>()
            }.add(dest)
        }

        val res = mutableListOf("JFK")

        fun dfs(src: String): Boolean {
            if(res.size == tickets.size + 1) {
                return true
            }

            val destination = adjList[src] ?: return false

            for(i in destination.indices) {
                val v = destination.removeAt(i)
                res.add(v)
                if(dfs(v)) return true
                res.removeLast()
                destination.add(i, v)
            }
            return false
        }

        dfs("JFK")
        return res
    }
}
