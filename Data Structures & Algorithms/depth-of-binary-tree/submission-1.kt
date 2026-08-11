/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {

        //BFS
        if(root == null) return 0

        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        var level = 0
        while(queue.isNotEmpty()) {

            val size = queue.size
            repeat(size) {
                val node = queue.removeFirst()
                node.left?.let{
                    queue.addLast(it)
                } 
                node.right?.let{
                    queue.addLast(it)
                } 
                
            }
            level++
        }

        return level

        //DFS
        // if(root == null) return 0

        // val left = maxDepth(root.left)
        // val right = maxDepth(root.right)

        // return 1+maxOf(left, right)
    }
}
