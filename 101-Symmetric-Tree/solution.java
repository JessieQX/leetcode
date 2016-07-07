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
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }//if one node is null, the recursion should stop, so use || but not &&. left == right means the addresses are equal.
         //if use true instead of left == right, the two nodes may have different values.
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
    
}