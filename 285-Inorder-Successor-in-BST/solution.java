/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            return minValue(p.right);
        }
        TreeNode curr = null;
        while (root != null) {
            if (root.val > p.val) {
                curr = root;
                root = root.left;
            } else if (root.val < p.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return curr;
    }
    private TreeNode minValue(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}