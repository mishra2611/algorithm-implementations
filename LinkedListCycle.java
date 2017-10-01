/*
 Author:     smishra, saraswatimishra18@gmail.com
 Date:       Sept 30, 2017
 Problem:    Linked List Cycle
 Difficulty: Easy
 



Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        ListNode slow, fast;
        fast=head.next;
        slow=head;
        while(fast!=null && fast.next!=null && slow!=null )
        {
            if(fast==slow)
                return true;
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }
}
