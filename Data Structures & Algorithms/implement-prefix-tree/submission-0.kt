data class TrieNode(
    val children: MutableMap<Char, TrieNode> = mutableMapOf<Char, TrieNode>(),
    var endOfWord: Boolean = false
)
class PrefixTree {

    private val root = TrieNode()

    fun insert(word: String) {
        var cur = root
        for(c in word) {
            cur.children.putIfAbsent(c, TrieNode())
            cur = cur.children[c]!!
        }
        cur.endOfWord = true
    }

    fun search(word: String): Boolean {
        var cur = root
        for(c in word) {
            if(c !in cur.children) {
                return false
            }
            cur = cur.children[c]!!
        }
        return cur.endOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var cur = root
        for(c in prefix) {
            if(c !in cur.children) {
                return false
            }
            cur = cur.children[c]!!
        }
        return true
    }
}
