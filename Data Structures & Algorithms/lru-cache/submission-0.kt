class LRUCache(capacity: Int) {

    private val capacity = capacity
    private val cache = mutableMapOf<Int, Node>()

    private class Node(
        val value:Int,
        val key: Int,
        var prev:Node? = null,
        var next:Node? = null
    )

    private val left: Node = Node(0, 0)
    private val right: Node = Node (0, 0)

    init {
        left.next = right
        right.prev = left
    }

    private fun remove(node: Node) {
        val prev = node.prev
        var next = node.next
        prev?.next = next
        next?.prev = prev
    }

    private fun insert(node: Node) {
        val prev = right.prev
        val next = right
        prev?.next = node
        right?.prev = node
        node.next = next
        node.prev = prev
    }

    fun get(key: Int): Int {
        return cache[key]?.let{ node ->
            remove(node)
            insert(node)
            node.value
        }?: -1
    }

    fun put(key: Int, value: Int) {
        cache[key]?.let { node ->
            remove(node)
            cache.remove(key)
        }

        val node = Node(key = key, value = value)
        cache[key] = node
        insert(node)

        if(cache.size > capacity) {
            left.next?.let{node -> 
                remove(node)
                cache.remove(node.key)
            }
        }
    }
}
