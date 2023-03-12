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
    public int numComponents(ListNode head, int[] nums) {
        int res = 0;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        while (head != null){
            if(set.contains(head.val)) {
                count++;
            }else if(count > 0){
                res++;
                count = 0;
            }
            head = head.next;
        }
        if(count > 0){
            res++;
            count = 0;
        }
        return res;
    }
}