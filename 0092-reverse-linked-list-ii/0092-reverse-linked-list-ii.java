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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode lNode = null, rNode = null, prevLNode = null;
        ListNode temp = head;
        int pos = 0;
        while (temp != null){
            ++pos;
            if(pos == left){
                lNode = temp;
            }else if(pos == right){
                rNode = temp.next;
                temp.next = null;
            }
            if(lNode == null){
                prevLNode = temp;
            }
            temp = temp.next;
        }
        ListNode newHead = null;
        ListNode lNodeTemp = lNode;
        while (lNode != null){
            ListNode next = lNode.next;
            lNode.next = newHead;
            newHead = lNode;
            lNode = next;
        }
        if(lNodeTemp == null) return head;
        lNodeTemp.next = rNode;
        if(prevLNode != null){
            prevLNode.next = newHead;
        }else{
            return newHead;
        }
        return head;
    }
}