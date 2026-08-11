/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val stack = mutableListOf<TreeNode?>()
        var cur: TreeNode? = root
        var k = k

        while(stack.isNotEmpty() || cur != null) {
            while(cur != null) {
                stack.add(cur)
                cur = cur.left
            }

            cur = stack.removeLast()
            k--
            if(k == 0) {
                return cur!!.`val`
            }

            cur = cur?.right
        }

        return 0
    }
}
