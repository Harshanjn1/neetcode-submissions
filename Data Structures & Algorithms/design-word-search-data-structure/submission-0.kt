data class TrieNode(
    val children : MutableMap<Char, TrieNode> = mutableMapOf<Char, TrieNode>(),
    var endOfWord: Boolean = false
)
class WordDictionary {

    var root = TrieNode()

    fun addWord(word: String) {
        var cur = root
        for(c in word) {
            cur.children.putIfAbsent(c, TrieNode())
            cur = cur.children[c]!!
        }
        cur.endOfWord = true
    }

    fun search(word: String): Boolean {
        return dfs(word, 0, root)
    }

    private fun dfs(word: String, i: Int, root: TrieNode): Boolean {
        var cur = root
        for(j in i until word.length) {
            if(word[j] == '.') {
                for(child in cur.children.values) {
                    if(dfs(word, j+1, child)) {
                        return true
                    }
                }
                return false
            } else {
                if(word[j] !in cur.children) {
                    return false
                }
                cur = cur.children[word[j]]!!                
            }
            
        }
        return cur.endOfWord
    }
}
