/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var preIdx = 0
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        // if(preorder.isEmpty() || inorder.isEmpty()) {
        //     return null
        // }

        // val root: TreeNode = TreeNode(preorder[0])
        // val mid = inorder.indexOf(preorder[0])
        // root.left = buildTree(preorder.sliceArray(1 until mid+1), inorder.sliceArray(0 until mid))
        // root.right = buildTree(preorder.sliceArray(mid+1 until preorder.size), inorder.sliceArray(mid+1 until inorder.size))
        // return root
        val map = inorder.withIndex().associate{
            (index, value) -> value to index
        }
        fun dfs(left: Int, right: Int): TreeNode? {
            if(left > right) return null

            val rootValue = preorder[preIdx++]
            val root = TreeNode(rootValue)
            val mid = map.get(rootValue)!!
            root.left = dfs(left, mid - 1)
            root.right = dfs(mid + 1, right)
            return root
        }

        return dfs(0, inorder.size - 1)
    }
}
