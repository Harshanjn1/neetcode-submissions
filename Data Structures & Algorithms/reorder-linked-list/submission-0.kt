/**
 * Definition for singly-linked list.
  * class ListNode(var `val`: Int) {
   *     var next: ListNode? = null
    * }
     */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        // find out the middle point of the list
        var slow: ListNode? = head
        var fast: ListNode? = head?.next
        while(fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        // now we have other half of the linked list
        var second = slow?.next
        slow?.next = null
        // lets reverse the linked list
        var prev:ListNode? = null
        while (second != null) {
            val next = second.next
            second.next = prev
            prev = second
            second = next
        }

        var firstList = head
        var secondList = prev
        // lets merge both the arrays
        while (secondList != null) {
            val next1 = firstList?.next
            val next2 = secondList?.next
            firstList?.next = secondList
            secondList?.next = next1
            firstList = next1
            secondList = next2
        }

    }
}
