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
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        //reverse pre-order recursion. find the right-est node and make it point to null. 
        //Then make the right-est node as prev, make the last left node as root pointing to prev.
        //Then make the root as prev, and find the last root as new root.
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}