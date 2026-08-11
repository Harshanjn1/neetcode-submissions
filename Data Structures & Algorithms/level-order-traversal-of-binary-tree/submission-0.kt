/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {

        var queue = ArrayDeque<TreeNode>()
        val res = mutableListOf<MutableList<Int>>()
        if(root==null) return res
        queue.addLast(root)
        while(queue.isNotEmpty()) {
            val size = queue.size
            val level = mutableListOf<Int>()
            for(i in 0 until size) {
                val node = queue.removeFirst()
                level.add(node.`val`)
                node.left?.let{queue.add(it)}
                node.right?.let{queue.add(it)}
            }
            res.add(level)

        }
        return res 

    }
}
