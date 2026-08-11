/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var res = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        dfs(root)
        return res
    }

    private fun dfs(node: TreeNode?): Int {
        if(node == null) return 0

        // compute left max
        val leftMax = max(dfs(node.left), 0)
        val rightMax = max(dfs(node.right), 0)

        // compute the result including the current node
        res = max(res, node.`val` + leftMax + rightMax)
        // return bast possible max path without splitting to the parent node
        return node.`val` + max(leftMax, rightMax)
    }
}
