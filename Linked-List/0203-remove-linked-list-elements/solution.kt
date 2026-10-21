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
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var p = dummy

       while (p.next != null) {
            if (p.next!!.`val` == `val`) {
                p.next = p.next.next
            } else {
                p = p.next
            }
        }

        return dummy.next
    }
}
