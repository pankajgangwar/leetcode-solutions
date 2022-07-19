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
    public int pairSum(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            n += 1;
        }
        int middle = n / 2;
        
        ListNode mid = head;
        while(middle-- > 0){
            mid = mid.next;
        }
        Deque<Integer> list = new ArrayDeque<>();
        while(mid != null){
            list.add(mid.val);
            mid = mid.next;
        }
        int max = 0;
        middle = n / 2;
        while(middle-- > 0){
            max = Math.max(max, list.pollLast() + head.val);
            head = head.next;
        }
        return max;
    }
}