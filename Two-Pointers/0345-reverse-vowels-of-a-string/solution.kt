class Solution {
    fun reverseVowels(s: String): String {
        val vowles = listOf('a','e','i','o','u','A', 'E','I','O','U')
        var l = 0
        var r = s.length - 1

        val arr = s.toCharArray()

        while(l<=r){
            if(vowles.contains(arr[l]) && vowles.contains(arr[r])){
                val temp = arr[r]
                arr[r] = arr[l]
                arr[l] = temp   
                r--
                l++
            } else if(vowles.contains(arr[l])){
                r--
            } else {
                l++
            }
        }

        return String(arr)
    }
}
