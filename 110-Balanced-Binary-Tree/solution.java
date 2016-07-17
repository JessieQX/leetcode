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
    
    public boolean isBalanced(TreeNode root) {
        int res = maxDepth(root);
        if (res == -1) {
            return false;
        }
        return true;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            //如果有一个分叉出现了>1的情况，那那个sub-root就是－1，它之后的每个点都是－1
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}