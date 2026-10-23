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
    fun getIntersectionNode(
        headA: ListNode?,
        headB: ListNode?
    ): ListNode? {

        fun getLength(head: ListNode?): Int {
            var current = head
            var length = 0

            while (current != null) {
                length++
                current = current.next
            }

            return length
        }

        var p1 = headA
        var p2 = headB

        val lenA = getLength(headA)
        val lenB = getLength(headB)

        if (lenA > lenB) {
            repeat(lenA - lenB) {
                p1 = p1?.next
            }
        } else {
            repeat(lenB - lenA) {
                p2 = p2?.next
            }
        }

        while (p1 != p2) {
            p1 = p1?.next
            p2 = p2?.next
        }

        return p1
    }
}
