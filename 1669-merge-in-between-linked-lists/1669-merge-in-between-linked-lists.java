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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev_a = null, next_b = null;
        boolean a_found = false;
        ListNode temp = list1;
        while (temp != null){
            if(!a_found && a-- == 0){
                a_found = true;
            }
            if(b-- == 0){
                next_b = temp.next;
                break;
            }
            if(!a_found){
                prev_a = temp;
            }
            temp = temp.next;
        }
        if(prev_a == null){
            list1 = list2;
        }else{
            prev_a.next = list2;
        }
        while (list2.next != null){
            list2 = list2.next;
        }
        list2.next = next_b;
        return list1;
    }
}