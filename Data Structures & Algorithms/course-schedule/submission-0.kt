class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val preMap = HashMap<Int, MutableList<Int>>()

        for(i in 0 until numCourses) {
            preMap[i] = mutableListOf<Int>()
        }

        for(prereq in prerequisites) {
            val (node, pre) = prereq
            preMap[node]!!.add(pre)
        }

        val visiting = HashSet<Int>()

        fun dfs(node: Int): Boolean {
            if(node in visiting) {
                return false
            }

            if(preMap[node]!!.isEmpty()) {
                return true
            }

            visiting.add(node)

            for(pre in preMap[node]!!) {
                if(dfs(pre).not()) {
                    return false
                }
            }
            visiting.remove(node)
            preMap[node] = mutableListOf()
            return true
        }

        for(c in 0 until numCourses) {
            if(dfs(c).not()) {
                return false
            }
        }
        return true
    }
}
