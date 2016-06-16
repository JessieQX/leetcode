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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        //int len = inorder.length;
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndex = i;
            }
        }
        root.left = build(root, inorder, 0, rootIndex - 1);
        root.right = build(root, inorder, rootIndex + 1, preorder.length - 1);
        return root;
    }
    public TreeNode build(TreeNode root, int[] inorder, int start, int end) {
        if (start >= end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        root = new TreeNode(nums[mid]);
        return root.left = build(root, inorder, 0, mid - 1) && root.right = build(root, inorder, mid + 1, end);
    }
}