/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode pointer = head;
        ListNode dummy = new ListNode(0);
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        helper(pointer, head, dummy);
        if (dummy.val == 1) {
            return dummy;
        }
        return head;
    }
    private void helper(ListNode pointer, ListNode head, ListNode dummy) {
        if (pointer.val < 9) {
            pointer.val = pointer.val + 1;
            return; 
        }
        pointer.val = 0;
        ListNode newPointer = null;
        
        if (pointer == head) {
            newPointer = dummy;
        } else {
            newPointer = head;
        }
        while (newPointer.next != pointer) {
            newPointer = newPointer.next;
        }
        helper(newPointer, head);
    }
}