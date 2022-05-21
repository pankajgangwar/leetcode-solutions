/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> mMinHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode n1, ListNode n2) {
				// TODO Auto-generated method stub
				return n1.val - n2.val;
			}
			
		});

		ListNode head = new ListNode(0);
		ListNode p = head;
		for (ListNode n : lists) {
			if(n != null) {
				mMinHeap.add(n);
			}
		}
        
		
		while (!mMinHeap.isEmpty()) {
			ListNode current = mMinHeap.poll();
			p.next = current;
			p = p.next;
			if(current.next != null) {
                System.out.println(current.val);
				mMinHeap.add(current.next);
			}
		}
		
		return head.next;
    }
}