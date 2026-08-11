class TrieNode() {
    val children = HashMap<Char, TrieNode>()
    var isWord = false

    fun addWord(word:String) {
        var cur = this
        for(c in word) {
            cur = cur.children.getOrPut(c) {TrieNode()}
        }
        cur.isWord = true
    }
}
class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = TrieNode()

        for(word in words) {
            root.addWord(word)
        }

        val rows = board.size
        val cols = board[0].size
        val res = HashSet<String>()
        val vis = HashSet<Pair<Int, Int>>()

        fun dfs(r: Int, c: Int, node: TrieNode, word:String) {
            if(r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] !in node.children ||
            (r to c) in vis) {
                return
            }

            vis.add(r to c)
            val nextNode = node.children[board[r][c]]!!
            val newWord = word + board[r][c]
            if(nextNode.isWord) {
                res.add(newWord)
            }
            dfs(r-1, c , nextNode, newWord)
            dfs(r+1, c , nextNode, newWord)
            dfs(r, c-1 , nextNode, newWord)
            dfs(r, c+1 , nextNode, newWord)
            vis.remove(r to c)
        }

        for(r in 0 until rows) {
            for(c in 0 until cols) {
                dfs(r, c , root , "")
            }
        }

        return res.toList()
    }
}
