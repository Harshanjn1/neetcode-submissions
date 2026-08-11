class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if(edges.size > n - 1 ) return false

        val adj = Array(n) {mutableListOf<Int>()}
        for(edge in edges) {
            val (parent, child)  = edge
            adj[parent].add(child)
            adj[child].add(parent)
        }
        val visit = HashSet<Int>()
        fun dfs(node: Int , parent: Int): Boolean {
            if(node in visit) return false
            visit.add(node)

            for(nei in adj[node]) {
                if(nei == parent) continue
                if(dfs(nei, node).not()) return false
            }
            return true
        }

        return dfs(0, -1) && visit.size == n 

    }
}
