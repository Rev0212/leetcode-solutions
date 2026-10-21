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
    fun deleteDuplicates(head: ListNode?): ListNode? {
       val dummy = head 
       var p = head
       
        while(p != null && p.next != null){
            if(p.`val` == p.next!!.`val`){
                p.next = p.next!!.next
            } else {
                p = p.next
            }
        }

        return dummy
    }
}
