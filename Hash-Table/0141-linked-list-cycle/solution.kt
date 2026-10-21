/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var s = head
        var f = head

        while(f != null && f?.next != null){
            s = s?.next 
            f = f.next?.next

            if(s == f){
                return true
            }

        }

        return false
    }
}
