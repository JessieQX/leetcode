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
        return build(inorder, postorder, 0, len - 1, len - 1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int start, int end, int postStart) {
        if (postStart < 0 || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        root.left = build(inorder, postorder, start, index - 1, postStart - start + index - 1);
        root.right = build(inorder, postorder, index + 1, end, postStart - 1);
        return root;
    }
}