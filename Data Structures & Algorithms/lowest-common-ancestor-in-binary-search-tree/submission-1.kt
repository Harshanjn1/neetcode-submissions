/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        // if(root == null || p == null || q == null) {
        //     return null
        // }

        // return when{
        //     max(p.`val`, q.`val`) < root.`val` -> lowestCommonAncestor(root.left, p , q)
        //     min(p.`val`, q.`val`) > root.`val` -> lowestCommonAncestor(root.right, p , q)   
        //     else -> root         
        // }

        var cur = root
        while(cur != null) {
            if(p!!.`val` > cur.`val` && q!!.`val` > cur.`val`) {
                cur = cur.right
            } else if(p!!.`val` < cur.`val` && q!!.`val` < cur.`val`) {
                cur = cur.left
            } else {
                return cur
            }
        }
        return null
    }
}
