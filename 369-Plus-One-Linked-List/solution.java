/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // public ListNode plusOne(ListNode head) {
    //     ListNode pointer = head;
    //     ListNode dummy = new ListNode(0);
    //     while (pointer.next != null) {
    //         pointer = pointer.next;
    //     }
    //     helper(pointer, head, dummy);
    //     if (dummy.val == 1) {
    //         return dummy;
    //     }
    //     return head;
    // }
    // private void helper(ListNode pointer, ListNode head, ListNode dummy) {
    //     if (pointer.val < 9) {
    //         pointer.val = pointer.val + 1;
    //         return; 
    //     }
    //     pointer.val = 0;
    //     ListNode newPointer = null;
        
    //     if (pointer == head) {
    //         dummy.next = head;
    //         newPointer = dummy;
    //     } else {
    //         newPointer = head;
    //     }
    //     while (newPointer.next != pointer) {
    //         newPointer = newPointer.next;
    //     }
    //     helper(newPointer, head, dummy);
    // }
    ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode node = null;
        while (cur.next != null) {
            if (cur.val != 9) {
                if (cur.next.val == 9) node = cur;
                else node = null;
            }
            cur = cur.next;
        }
        if (node == null) {
            cur.val ++;
            return head;
        } else if (node == dummy) {
            dummy.val++;
            while (head!= null) {
                head.val = 0;
                head = head.next;
            }
            return dummy;
        } else {
            node.val++;
            while (node.next!= null) {
                node.next.val = 0;
                node = node.next;
            }
            return head;
        }
}