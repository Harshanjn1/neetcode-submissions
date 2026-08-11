/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {

        // recursive approach
        // base case 
        if(head == null || head.next == null) {
            return head
        }

        val reverseNode = reverseList(head.next)
        head.next?.next = head
        head.next = null

        return reverseNode



        // var prevNode:ListNode? = null
        // var curNode = head
        // while(curNode != null) {
        //     // we are breaking the connection from cur node to 
        //     // next node so save it before breaking the connection.
        //     val nextNode = curNode.next

        //     //reverse the link 
        //     curNode.next = prevNode
        //     // assign new prev value
        //     prevNode = curNode
        //     // move the current node
        //     curNode = nextNode
        // }
        // // at the end prev node will be pointing to the new 
        // // beginning of the linked list , its nothing but head so return it
        // return prevNode
    }
}
