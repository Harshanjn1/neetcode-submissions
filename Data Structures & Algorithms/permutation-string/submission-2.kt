class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
         val count1 = HashMap<Char, Int>() 
        for(i in s1.indices) { 
            count1[s1[i]] = count1.getOrDefault(s1[i], 0) + 1 
        } 
        
        val need = count1.size 
        
        for(j in s2.indices) { 
            var cur = 0 
            var count2 = HashMap<Char,Int>() 
            for(k in j until s2.length) { 
                count2[s2[k]] = count2.getOrDefault(s2[k], 0) + 1 
                if(count1.getOrDefault(s2[k], 0) < count2[s2[k]]!!) { 
                    break 
                } 
                if(count1.getOrDefault(s2[k], 0) == count2[s2[k]]!!) { 
                    cur++ 
                } 
                if(cur == need) { 
                    return true 
                } 
            } 
        } 
        return false 
    }
}
