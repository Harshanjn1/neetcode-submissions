class Solution {
    fun isValid(s: String): Boolean {
        if(s.length % 2 != 0) {
            return false
        }
        val validPairMap = hashMapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )
        val stack = ArrayDeque<Char>()
        for(i in s.indices) {
            // if its a opening brackets , keep pushing to the stack
            if(validPairMap.containsKey(s[i])) {
                // if its closing ones , check the top of the stack 
                // is valid pair of the current bracket
                if(stack.isEmpty() || stack.removeLast() != validPairMap[s[i]]) {
                    return false
                } 
            } else {
               stack.addLast(s[i]) 
            }
        }

        return stack.isEmpty()

    }
}
 