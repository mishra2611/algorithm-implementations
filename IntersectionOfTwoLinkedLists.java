/*
@Author: Saraswati Mishra

160. Intersection of Two Linked Lists 
 
Write a program to find the node at which the intersection of two singly linked lists begins.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1=0, len2=0;
        ListNode tmp=headA, head1=headA, head2=headB;
        while(tmp!=null)
        {
            len1++;
            tmp=tmp.next;
        }
        tmp=headB;
        while(tmp!=null)
        {
            len2++;
            tmp=tmp.next;
        }
        System.out.println(len1+" "+len2);
        while(len1<len2 && head2!=null)
        {
            head2=head2.next;
            len2--;
        }
        while(len2<len1 && head1!=null)
        {
            head1=head1.next;
            len1--;
        }
        if(head1==null||head2==null)
            return null;
        while(head1!=null|| head2!=null)
        {
            if(head1==head2)
                return head1;
            head1=head1.next;
            head2=head2.next;
        }
        return null;
        
    }
}
