/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //return swapRecursion(head);
        //return swapRecEasy(head);
        return swapIterative(head);
    }
    
    public ListNode swapIterative(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;
        ListNode swap1 = null;
        ListNode swap2 = null;

        while(point.next != null && point.next.next != null){
            swap1 = point.next;
            swap2 = point.next.next;

            point.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            point = swap1;
        }
        return dummy.next;
    }
    
    public ListNode swapRecEasy(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode n = head.next;
        head.next = swapRecEasy(head.next.next);
        n.next = head;
        return n;
    }

    public ListNode swapRecursion(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode remaining = head.next.next;

        ListNode newhead = head.next;
        
        head.next.next = head;
        
        head.next = swapRecursion(remaining);
        
        return newhead;
    }
}