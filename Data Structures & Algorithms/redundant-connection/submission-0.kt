class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size
        val par = IntArray(n+1) {it}
        val rank = IntArray(n+1) {
            1
        }

        fun find(node: Int): Int {
            if(node != par[node]) {
                par[node] = find(par[node])
            }

            return par[node]
        }

        fun union(u: Int, v: Int): Boolean {
            val pu = find(u)
            val pv = find(v)
            if(pu == pv) {
                return false
            }

            if(rank[pu] > rank[pv]) {
                par[pv] = pu
                rank[pu] += rank[pv]
            } else {
                par[pu] = pv
                rank[pv] += rank[pu]
            }
            return true
        }

        for((u,v) in edges) {
            if(union(u,v).not()) {
                return intArrayOf(u, v)
            }
        }
        return intArrayOf()
    }
}
