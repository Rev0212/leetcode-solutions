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
    ListNode* reverseList(ListNode* head) {
    stack<int>container;
    ListNode *temp =head;
    while(temp != NULL)
    {
        container.push(temp->val);
        temp=temp->next;
    }
    temp=head;
    while(temp != NULL)
    {
        temp->val=container.top();
        container.pop();
        temp=temp->next;
    }
    return head;
        
    }
};
