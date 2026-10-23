class Solution {
    fun isHappy(n: Int): Boolean {
          var current = n
val set = mutableSetOf<Int>()

while (current != 1) {

    if(set.contains(current)){
        return false
    } else{
        set.add(current)
    }

    var sum = 0

    while (current > 0) {
        val digit = current % 10
        sum += digit * digit
        current /= 10
    }

    current = sum
}

return true  
    }
}
