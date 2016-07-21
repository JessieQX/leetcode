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
        if (root.val == target) {
            return root.val;
        }
        int less = -1, more = -1;
        if (root.val < target) {
            less = closestValue(root.right, target);
        } else {
            more = closestValue(root.left, target);
        }
        if ((target - less) < (more - target)) {
            return less;
        } else {
            return more;
        }
    }
}