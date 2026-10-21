/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {
    
        // Find the node just before the ath node
        ListNode* prevA = nullptr;
        ListNode* curr = list1;
        for (int i = 0; i < a; ++i) {
            prevA = curr;
            curr = curr->next;
        }

        // Find the node at the bth position
        ListNode* nodeB = curr;
        for (int i = a; i < b; ++i) {
            nodeB = nodeB->next;
        }

        // Find the tail of list2
        ListNode* tailList2 = list2;
        while (tailList2->next) {
            tailList2 = tailList2->next;
        }

        // Connect the list before a with list2 and the list after b
        if (prevA) {
            prevA->next = list2;
        } else {
            list1 = list2;
        }
        tailList2->next = nodeB->next;

        return list1;
    }
};
