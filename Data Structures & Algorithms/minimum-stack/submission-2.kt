class MinStack() {

    private var min:Long = Long.MAX_VALUE
    private val stack = ArrayDeque<Long>()

    fun push(`val`: Int) {
        val num = `val`.toLong()
        if(stack.isEmpty()) {
            stack.addLast(0)
            min = num
        } else {
            stack.addLast(num - min)
            if(num < min) {
                min = num
            }
        }
    }

    fun pop() {
        if(stack.isEmpty()) return 
        val pop = stack.removeLast()
        if(pop < 0) {
            min -= pop
        }
    }

    fun top(): Int {
        return if(stack.last() < 0) {
            min.toInt()
        } else {
            stack.last().toInt() + min.toInt()
        }
    }

    fun getMin(): Int {
        return min.toInt()
    }
}
