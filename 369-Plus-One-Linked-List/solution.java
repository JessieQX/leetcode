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
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        helper(pointer, head);
        return head;
    }
    private void helper(ListNode pointer, ListNode head) {
        if (pointer.val < 9) {
            pointer.val = pointer.val + 1;
            return; 
        }
        pointer.val = 0;
        ListNode newPointer = null;
        
        if (pointer == head) {
            ListNode dummy = null;
            dummy.next = head;
            dummy.val = 0;
            newPointer = dummy;
        } else {
            newPointer = head;
        }
        while (newPointer.next != pointer) {
            newPointer = newPointer.next;
        }
        //newPointer.val = newPointer.val + 1;
        helper(newPointer, head);
    }
}