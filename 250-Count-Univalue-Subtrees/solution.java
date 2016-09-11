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
    private boolean isUnivalue(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isUnivalue(root.left);
        boolean right = isUnivalue(root.right);
        if (left && right) {//不能直接在if里写if(isUnivalue(root.left) && isUnivalue(root.right))，可能是在left为false的情况下不会判断right直接进入false
            if (root.left != null && root.val != root.left.val) return false;
            if (root.right != null && root.val != root.right.val) return false;
            count++;
            return true;
        }
        return false;
    }
}