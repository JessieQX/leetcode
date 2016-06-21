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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;
        return build(inorder, postorder, len - 1, 0, len - 1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int start, int end, int postStart) {
        if (postStart < 0 || start < end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        int index = start;
        for (int i = start; i >= end; i--) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        root.right = build(inorder, postorder, start, index + 1, postStart - 1);
        root.left = build(inorder, postorder, index - 1, end, postStart - start + index - 1);
        return root;
    }
}