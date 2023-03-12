/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int sum = 0;
        while (head != null){
            int data = head.val;
            if(data == 0){
                if(sum != 0){
                    dummy.next = new ListNode(sum);
                    dummy = dummy.next;
                }
                sum = 0;
            }else{
                sum += data;
            }
            head = head.next;
        }
        return temp.next;
    }
}