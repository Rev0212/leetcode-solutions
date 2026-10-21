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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val s1 = ArrayDeque<Int>()
        val s2 = ArrayDeque<Int>()

        var p1 = l1
        var p2 = l2


        while (p1 != null) {
            s1.addLast(p1.`val`)
            p1 = p1.next
        }

        while (p2 != null) {
            s2.addLast(p2.`val`)
            p2 = p2.next
        }

        var carry = 0
        var head: ListNode? = null

        while (s1.isNotEmpty() || s2.isNotEmpty() || carry != 0) {
            val x = if (s1.isNotEmpty()) s1.removeLast() else 0
            val y = if (s2.isNotEmpty()) s2.removeLast() else 0

            val sum = x + y + carry
            carry = sum / 10

            val node = ListNode(sum % 10)
            node.next = head
            head = node
        }

        return head
    }
}
