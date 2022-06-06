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
        int lengthA = 0, lengthB = 0;
        ListNode tempA = headA, tempB = headB;
        while(tempA != null){
            tempA = tempA.next;
            lengthA++;
        }
        
        while(tempB != null){
            tempB = tempB.next;
            lengthB++;
        }
        
        if(lengthA < lengthB){
            while(lengthA != lengthB){
                headB = headB.next;
                lengthB--;
            }
        }else if(lengthA > lengthB){
            while(lengthA != lengthB){
                headA = headA.next;
                lengthA--;
            }
        }
        
        while(headA != null && headB != null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
        
    }
}