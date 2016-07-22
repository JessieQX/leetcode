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
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0, root.val);
        return max;
    }
    private void helper(TreeNode root, int count, int target) {
        if (root == null) return;
        if (root.val == target) {
            count++;
        } else {
            count = 1;
        }
        max = Math.max(count, max);
        helper(root.left, count, root.val + 1);
        helper(root.right, count, root.val + 1);
    }
}