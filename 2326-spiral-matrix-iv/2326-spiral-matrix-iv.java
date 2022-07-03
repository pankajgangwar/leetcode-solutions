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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }
        int up = 0, down = m - 1;
        int left = 0, right = n - 1;
        int count = 0;
        while (head != null){
            for (int i = left; i <= right && count < n*m && head != null; i++){
                res[up][i] = head.val;
                head = head.next;
                count++;
            }
            for (int i = up + 1; i <= down - 1 && count < n*m && head != null; i++){
                res[i][right] = head.val;
                head = head.next;
                count++;
            }
            for (int i = right; i >= left && count < n*m && head != null; i--){
                res[down][i] = head.val;
                head = head.next;
                count++;
            }
            for (int i = down - 1; i >= up + 1 && count < n*m && head != null; i--) {
                res[i][left] = head.val;
                head = head.next;
                count++;
            }
            left++;right--;up++;down--;
        }
        return res;
    }
}