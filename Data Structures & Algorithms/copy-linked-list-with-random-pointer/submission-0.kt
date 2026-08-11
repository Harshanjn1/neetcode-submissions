/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        // map to store the old node and deep copy of the new node
        val map = HashMap<Node?, Node?>()
        map[null] = null
        var cur = head
        while(cur != null) {
            map[cur] = Node(cur.`val`)
            cur = cur?.next
        }

        var iteratorNode = head
        while(iteratorNode != null) {
            val copy = map[iteratorNode]
            copy?.next = map[iteratorNode.next]
            copy?.random = map[iteratorNode.random]
            iteratorNode = iteratorNode?.next
        }

        return map[head]
    }
}
