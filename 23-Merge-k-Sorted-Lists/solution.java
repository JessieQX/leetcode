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
        // if (lists == null || lists.length == 0) return null;
        // PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        // for (ListNode node : lists) {
        //     while (node != null) {
        //         pq.offer(node);
        //         node = node.next;
        //     }
        // }
        
        // ListNode dummy = new ListNode(0);
        // ListNode node = dummy;
        // while (!pq.isEmpty()) {
        //     node.next = pq.poll();
        //     node = node.next;
        //     if (node.next != null) {
        //         pq.offer(node.next);
        //     }
        // }
        // return head;
        if (lists==null||lists.length==0) return null;
        
        // PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
        //     @Override
        //     public int compare(ListNode o1,ListNode o2){
        //         if (o1.val<o2.val)
        //             return -1;
        //         else if (o1.val==o2.val)
        //             return 0;
        //         else 
        //             return 1;
        //     }
        // });
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (a, b) -> (a.val - b.val));
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}