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
    public ListNode detectCycle(ListNode head) {
        
        if(head == null) return null;
        
        ListNode tortoise = head;
        ListNode hare = head;
        
        while(hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(tortoise == hare){
                break;
            }
        }
        
        if(hare == null || hare.next == null) return null;
        
        tortoise = head;
        
        while(tortoise != hare){
            tortoise = tortoise.next;
            hare = hare.next;
        }
        return tortoise;
    }
}