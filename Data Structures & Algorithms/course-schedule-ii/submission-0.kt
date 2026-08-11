class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val preqMap = HashMap<Int, MutableList<Int>>()
        for(i in 0 until numCourses) {
            preqMap[i] = mutableListOf<Int>()
        }

        for(preq in prerequisites) {
            val (node, edge) = preq
            preqMap[node]!!.add(edge)
        }

        val visit = HashSet<Int>()
        val output = mutableListOf<Int>()
        val cycle = HashSet<Int>()

        fun dfs(node:Int): Boolean {
            if(node in cycle) return false
            if(node in visit) return true

            cycle.add(node)
            for(pre in preqMap[node]!!){
                if(dfs(pre).not()) return false
            }

            cycle.remove(node)
            visit.add(node)
            output.add(node)
            return true
        }

        for(i in 0 until numCourses) {
            if(dfs(i).not()) return intArrayOf()
        }

        return output.toIntArray()
    }
}
