/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)

        var cur: ListNode? = dummy
        var carry = 0
        var p1 = l1
        var p2 = l2
        while(p1 != null || p2 != null || carry != 0) {
            val v1 = p1?.`val` ?: 0
            val v2 = p2?.`val` ?: 0

            val res = v1 + v2 + carry
            carry = res / 10
            cur?.next = ListNode(res % 10)
            cur = cur?.next
            p1 = p1?.next
            p2 = p2?.next
        }

        return dummy?.next
    }
}
