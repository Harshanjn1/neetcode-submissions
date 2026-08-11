/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var currentList = lists.toList()

        if(lists.isEmpty()) return null

        while(currentList.size > 1) {
            val mergedList = mutableListOf<ListNode?>()

            for(i in currentList.indices step 2) {
                val l1 = currentList[i]
                val l2 = if(i+1 < currentList.size) currentList[i+1] else null

                mergedList.add(mergeTwoList(l1, l2))
            }
            currentList = mergedList
        }

        return currentList[0]
    }

    private fun mergeTwoList(node1: ListNode?, node2: ListNode?): ListNode? {
        val dummy = ListNode(0)

        var res = dummy
        var n1 = node1
        var n2 = node2
        while(n1 != null && n2 != null) {
            if(n1.`val` < n2.`val`) {
                res?.next = n1
                n1 = n1?.next
            } else {
                res?.next = n2
                n2 = n2?.next
            }
            res = res.next!!
        }

        res?.next = n1 ?: n2

        return dummy?.next
    }
}
