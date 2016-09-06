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
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode node : lists) {
            while (node != null) {
                pq.offer(node);
                node = node.next;
            }
        }
        
        ListNode head = pq.poll();
        ListNode node = head;
        while (!pq.isEmpty()) {
            node.next = pq.poll();
            node = node.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return head;
    }
}