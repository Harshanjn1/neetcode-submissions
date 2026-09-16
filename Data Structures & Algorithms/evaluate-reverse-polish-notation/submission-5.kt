class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for(token in tokens) {
            if(token in setOf("+", "-", "*", "/")) {
                when(token) {
                    "+" -> {
                            val a = stack.removeLast()
                            val b = stack.removeLast()
                            stack.addLast(b+a)
                        }
                    "-" -> {
                            val a = stack.removeLast()
                            val b = stack.removeLast()
                            stack.addLast(b-a)
                        }
                    "*" -> {
                            val a = stack.removeLast()
                            val b = stack.removeLast()
                            stack.addLast(b*a)
                        }
                    else -> {
                            val a = stack.removeLast()
                            val b = stack.removeLast()
                            stack.addLast(b/a)
                        }
                }
            } else {
                stack.addLast(token.toInt())
            }
        }
        return stack.removeLast()
    }
}
