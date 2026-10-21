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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var f: ListNode? = dummy
        var s: ListNode? = dummy

        repeat(n+1){
            f = f?.next
        }

        while(f != null){
            s = s?.next
            f = f.next
        }
        s?.next = s?.next?.next 
        return dummy.next
    }

}
