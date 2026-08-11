/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    private var isBalanced = true
    fun isBalanced(root: TreeNode?): Boolean {
        calculateHeight(root)
        return isBalanced
    }

    private fun calculateHeight(node: TreeNode?): Int {
        if(node == null) {
            return 0
        }

        val left = calculateHeight(node.left)
        val right = calculateHeight(node.right)

        if(abs(left - right) > 1) {
            isBalanced = false
        }

        return 1 + max(left, right)
    }
}
