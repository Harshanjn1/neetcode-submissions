class Solution {
    fun foreignDictionary(words: Array<String>): String {
        val adj = HashMap<Char, MutableSet<Char>>()
        // create a empty adjeceny list
        for(word in words) {
            for(character in word) {
                adj.putIfAbsent(character, mutableSetOf<Char>())
            }
        }

        // lets fill in the adjaceny graph in a topological sorting order
        for(i in 0 until words.size - 1) {
            val w1 = words[i]
            val w2 = words[i+1]

            // if the two words have the same prefix and if the larger length word 
            // comes before the shorter one , its invalid as per the requirement so return ""

            val minLength = min(w1.length, w2.length)
            if(w1.length > w2.length && w1.substring(0, minLength) == w2.substring(0, minLength)) {
                return ""
            }

            for(j in 0 until minLength) {
                if(w1[j] != w2[j]) {
                    adj[w1[j]]?.add(w2[j])
                    break
                }
            }
        }

        val res = mutableListOf<Char>()
        val visit = HashMap<Char, Int>()

        // using dfs to traverse the adjacency list , if we find detect the cycle return true 
        // if the traversal is valid add the node to the result 

        // visit[char] == 1 -> char in current dfs iteration
        // visit[char] == -1 -> char is completely processed
        fun dfs(node: Char): Boolean {
            if(node in visit) {
                return visit[node] == 1
            }

            visit[node] = 1

            for(nei in adj[node]?: emptySet()) {
                if(dfs(nei)) return true
            }

            visit[node] = -1
            res.add(node)
            return false
        }

        for(key in adj.keys) {
            if(dfs(key)) {
                return ""
            }
        }

        return res.reversed().joinToString("")
    }
}
