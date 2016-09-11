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
    private static int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }
    private TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if (left == null && right == null) {
            System.out.println("a");
            count++;
        } else if (left == null && root.val == right.val) {
            count++;
        } else if (right == null && root.val == left.val) {
            count++;
        } else if (left.val == right.val && left.val == root.val) {
            System.out.println("b");
            count++;
        }
        return root;
    }
}