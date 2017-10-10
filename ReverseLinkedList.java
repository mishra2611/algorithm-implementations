/*
@Author: Saraswati  Mishra
Reverse a singly linked list.
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
    ListNode headMain;
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        reverse(head);
        return headMain;
        
    }
    
    ListNode reverse(ListNode n)
    {
        ListNode curr=n, nex;
        if(n.next==null)
        {
            headMain=n;
            return headMain;
        }
         nex=reverse(curr.next);
        nex.next=curr;
           curr.next=null;
          return curr;
        
    }
}
