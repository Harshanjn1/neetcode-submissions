/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if(node == null) return null

        val map = HashMap<Node, Node>()
        fun dfs(node: Node): Node {
            if(node in map) {
                return map[node]!!
            }

            val copy = Node(node.`val`)
            map[node] = copy
            for(nei in node.neighbors) {
                nei?.let{
                    copy.neighbors.add(dfs(it))
                }
            }
            return copy
        }
        return dfs(node)
    }
}
