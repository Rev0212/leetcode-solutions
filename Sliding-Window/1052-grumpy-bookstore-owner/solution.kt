class Solution {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
        
    var statisfied = 0

    for(i in 0 until customers.size){
        if(grumpy[i] == 0){
            statisfied += customers[i]
        }        
    }

    var extra = 0

    for(i in 0 until minutes){
        if(grumpy[i] == 1){
            extra += customers[i]
        }
    }

    var maxExtra = extra

    for(i in minutes until customers.size){
        if(grumpy[i] == 1){
            extra += customers[i]
        }

        if(grumpy[i - minutes] == 1){
             extra -= customers[i - minutes]
        }

        maxExtra = maxOf(extra,maxExtra)
    }

    return statisfied + maxExtra

    }
}
