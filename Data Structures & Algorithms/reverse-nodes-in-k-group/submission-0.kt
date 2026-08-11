/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var groupPrev: ListNode? = dummy

        while(true) {
            val kth = getKthNode(groupPrev, k)
            if(kth == null) {
                break
            }

            var groupNext = kth?.next
            // prev is kth.next instead of null because the first element in the group
            // eventually connect to first element of the next group after reversing
            var prev = kth?.next
            var cur = groupPrev?.next
            
            while(cur != groupNext) {
                val temp = cur?.next
                cur?.next = prev
                prev = cur
                cur = temp
            }

            val temp: ListNode? = groupPrev?.next
            // connecting previous group with the newly reversed group
            groupPrev?.next = kth
            // updating next groupPrev that is just next of last groupPrev
            // because anyways once we reverse the group the first element of the 
            // group will become last element of the group that is groupPrev element 
            // for the next group.
            groupPrev = temp

        }

        return dummy.next
    }

    private fun getKthNode(head: ListNode?, k: Int): ListNode? {
        var cur = head
        var k = k

        while(cur != null && k >0) {
            cur = cur?.next
            k--
        }

        return cur
    }
}
