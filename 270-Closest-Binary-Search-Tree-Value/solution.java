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
            return target;
        }
        if (root.val < target) {
            int less = closestValue(root.right, target);
        } else {
            int more = closestValue(root.left, target);
        }
        return (target - less) < (more - target) : less ? more;
    }
}