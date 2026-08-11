/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var cur = head
        val nodeSet = HashSet<ListNode>()
        while (cur != null) {
            if(nodeSet.add(cur).not()) {
                return true
            }
            cur = cur.next
        }
        return false
    }
}
