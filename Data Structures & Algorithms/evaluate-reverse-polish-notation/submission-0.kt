class Solution {
    class DoublyLinkedList(
        var value: String, 
        var prev: DoublyLinkedList? = null,
        var next: DoublyLinkedList? = null,
    )

    fun evalRPN(tokens: Array<String>): Int {
        val head = DoublyLinkedList(
            tokens[0]
        )
        var cur = head
        for (i in 1 until tokens.size) {
            val node = DoublyLinkedList(
                tokens[i],
                prev = cur
            )

            cur.next = node
            cur = node
        }

        var ptr: DoublyLinkedList? = head
        val operatorSet = setOf("+", "-", "/", "*")
        while(ptr != null) {
            if(ptr.value in operatorSet) {
                val l = ptr.prev!!.prev!!.value.toInt()
                val r = ptr.prev!!.value.toInt()

                val res = when(ptr.value) {
                    "+" -> l + r
                    "-" -> l - r
                    "/" -> l / r
                    else -> l * r
                }

                ptr.value = res.toString()
                ptr.prev = ptr.prev!!.prev!!.prev
                ptr.prev?.next = ptr
            }
            ptr = ptr?.next
        }

        return cur.value.toInt()
    }
}
