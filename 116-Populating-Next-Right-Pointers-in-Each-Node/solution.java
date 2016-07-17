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
        
        //root.next = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Queue<TreeLinkNode> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeLinkNode head = queue.poll();
                level.offer(head);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            
            int size1 = level.size();
            for (int i = 0; i < size1; i++) {
                TreeLinkNode node = level.poll();
                if (!level.isEmpty()) {
                    node.next = level.peek();
                } else {
                    node.next = null;
                }
            }
        }
        return;
    }
}