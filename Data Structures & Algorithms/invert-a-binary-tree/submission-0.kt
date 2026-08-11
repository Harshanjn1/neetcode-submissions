/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if(root == null) return null
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while(queue.isNotEmpty()) {
            val node = queue.removeFirst()
            node?.let{ node ->
                val temp = node.left
                node.left = node.right
                node.right = temp

                node.left?.let{queue.add(it)}
                node.right?.let{queue.add(it)}
            }
            
        }

        return root
    }
}
