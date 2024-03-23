/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode l1 = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;

        ListNode l2 = reverse(slow);

        merge(l1,l2);
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void merge(ListNode l1, ListNode l2){
        ListNode next1 = null;
        ListNode next2 = null;
        while(l1 != null && l2 != null){
            next1 = l1.next;
            next2 = l2.next;
            l1.next = l2;
            
            if(next1 == null) break;

            l2.next = next1;

            l1 = next1;
            l2 = next2;
        }
    }
}
