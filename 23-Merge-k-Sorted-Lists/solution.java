/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //0->2->5->8
        //1->3->4->6
        //7->9
        //[0,1,7]
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode node : lists) {
            while (node != null) {
                pq.offer(node);
                node = node.next;
            }
        }
        
        ListNode head = new ListNode(pq.poll());
        while (!pq.isEmpty()) {
            head.next = pq.poll();
            head = head.next;
        }
        return head;
    }
}