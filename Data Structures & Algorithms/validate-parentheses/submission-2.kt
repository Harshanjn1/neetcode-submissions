class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val map = hashMapOf(')' to '(', ']' to '[', '}' to '{')

        for(c in s) {
            if(map.containsKey(c)) {
                if(stack.isNotEmpty() && stack.first() == map[c]) {
                    stack.removeFirst()
                } else {
                    return false
                }
            } else {
                stack.addFirst(c)
            }
        }
        return stack.isEmpty()
    }
}
