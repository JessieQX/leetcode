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
    // public boolean isValidBST(TreeNode root) {
    //     // write your code here
    //     return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    // }
    // public boolean helper(TreeNode root, long min, long max) {
    //     if (root == null) {
    //         return true;
    //     }
    //     if (min >= root.val || max <= root.val) {
    //         return false;
    //     }
    //     return helper(root.left, min, root.val) && helper(root.right,root.val, max);
    // }
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null) {
            if (root.left.val > root.val) return false;
        }
        if (root.right != null) {
            if (root.right.val < root.val) return false;
        }
        
        return isValid(root.left) && isValid(root.right);
    }
}