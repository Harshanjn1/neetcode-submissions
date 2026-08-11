/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0).apply{
            next = head
        }

        var count = n
        var right: ListNode? = head
        var left: ListNode? = dummy
        while (count > 0) {
            right = right?.next
            count--
        }

        while(right != null) {
            right = right?.next
            left = left?.next
        }

        left?.next = left?.next?.next
        return dummy?.next
    }
}
