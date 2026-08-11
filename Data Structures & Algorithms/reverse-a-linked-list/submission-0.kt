/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prevNode:ListNode? = null
        var curNode = head
        while(curNode != null) {
            val nextNode = curNode.next
            curNode.next = prevNode
            prevNode = curNode
            curNode = nextNode
        }
        return prevNode
    }
}
