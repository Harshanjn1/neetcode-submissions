class TimeMap() {

    private val map = HashMap<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.getOrPut(key){mutableListOf<Pair<Int, String>>()}.add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        var res = ""
        val mapValue = map[key] ?: return res
        val valueList = map[key]!!

        var l = 0
        var r = valueList.size - 1
        while(l <= r) {
            val mid = l + (r - l) / 2
            if(valueList[mid].first <= timestamp) {
                res = valueList[mid].second
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return res
    }
}
