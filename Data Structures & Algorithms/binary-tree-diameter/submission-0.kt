/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    private var res = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        getMaxHeight(root)
        return res
    }

    private fun getMaxHeight(node: TreeNode?): Int {
        if(node == null) {
            return 0
        }

        val left = getMaxHeight(node.left)
        val right = getMaxHeight(node.right)

        res = max(res, left + right)

        return 1 + max(left, right)
    }
}
