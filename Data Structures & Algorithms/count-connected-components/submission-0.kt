class DSU(n: Int) {
    val parent = IntArray(n) {it}
    val rank = IntArray(n) {1}

    fun find(node: Int): Int {
        var cur = node
        while(cur != parent[cur]) {
            parent[cur] = parent[parent[cur]]
            cur = parent[cur]
        }
        return cur
    }

    fun union(u: Int, v: Int): Boolean {
        val pv= find(v)
        val pu = find(u)

        if(pv == pu) {
            return false
        }

        if(rank[pv] > rank[pu]) {
            parent[pu] = pv
            rank[pv] += rank[pu]
        } else {
            parent[pv] = pu
            rank[pu] += rank[pv]
        }
        return true
    }
}

class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val dsu = DSU(n)
        var res = n
        for((u, v) in edges) {
            if(dsu.union(u,v)) {
                res--
            }
        }
        return res
    }
}
