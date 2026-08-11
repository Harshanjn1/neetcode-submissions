/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var cur1 = list1
        var cur2 = list2
        val dummy = ListNode(0)
        var resNode: ListNode? = dummy
        while(cur1 != null && cur2 != null) {
            if(cur1.`val` <= cur2.`val`) {
                resNode?.next = cur1
                cur1 = cur1.next
            } else {
                resNode?.next = cur2
                cur2 = cur2.next
            }
            resNode = resNode?.next
        }

        resNode?.next = cur1?:cur2

        return dummy.next

    }
}
