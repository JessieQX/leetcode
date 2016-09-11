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
    class Result {
        int size;
        int lower;
        int upper;
        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    private int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }
    private Result helper(TreeNode root) {
        if (root == null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Result left = helper(root.left);
        Result right = helper(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new Result(-1, 0, 0);
        }
        int size = left.size + right.size + 1;
        max = Math.max(max, size);
        return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
}