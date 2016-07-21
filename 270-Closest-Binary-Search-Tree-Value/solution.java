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
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        
        if (root.val < target) {
            int less = closestValue(root.right, target);
        } else {
            int more = closestValue(root.left, target);
        }
        if ((target - less) < (more - target)) {
            return less;
        } else {
            return more;
        }
    }
}