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
    public TreeNode build(int[] inorder, int[] postorder, int start, int end, int mid) {
        if (mid > inorder.length - 1 || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[mid]);
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }
        root.left = build(inorder, postorder, start, index - 1, mid - start + index - 1);
        root.right = build(inorder, postorder, index + 1, end, mid - 1);
        return root;
    }
}