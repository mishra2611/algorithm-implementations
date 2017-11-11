/*
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. 

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode newhead=null, tail=null;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count=1;
        ListNode prev=null, curr=head, rev=null;
        while(count<m)
        {
            prev=curr;
            curr=curr.next;
            count++;
        }
        
        rev=reverse(curr, n-m);
        if(prev!=null)
            prev.next=newhead;
        if(rev!=null)
            rev.next=tail;
        if(m==1)
            return newhead;
        return head;
    }


 ListNode reverse(ListNode curr, int count)
    {
        ListNode prev=null, tmp=null;
        if(count==0)
        {
            tail=curr.next;
            newhead=curr;
            return curr;
        }
        else
        {
            count--;
            tmp=reverse(curr.next,count);
            tmp.next=curr;
            return curr;
        }
    }
}
