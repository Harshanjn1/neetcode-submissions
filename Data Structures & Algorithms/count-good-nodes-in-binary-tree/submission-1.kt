/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {

        if(root == null) {
            return 0
        }

        fun dfs(node: TreeNode?, maxVal: Int): Int {
            var res = 0
            if(node == null) return res
            if(node.`val` >= maxVal){
                res = 1
            }
            val newMaxVal = max(maxVal, node.`val`)
            
            res += dfs(node.left, newMaxVal)
            res += dfs(node.right, newMaxVal)

            return res
        }
        return dfs(root, root.`val`)
    }
}
