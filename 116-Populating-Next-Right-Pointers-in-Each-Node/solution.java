/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        root.next = null;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeLinkedNode head = queue.poll();
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            for (int i = 0; i < queue.size(); i++) {
                TreeLinkedNode head = queue.poll();
                if (!queue.isEmpty()) {
                    head.next = queue.peek();
                } else {
                    head.next = null;
                }
            }
        }
        return;
    }
}