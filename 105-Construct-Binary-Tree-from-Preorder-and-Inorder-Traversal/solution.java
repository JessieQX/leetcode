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
    //public TreeNode buildTree(int[] preorder, int[] inorder) {
        // if (preorder == null || preorder.length == 0) return null;
        // if (inorder == null || inorder.length == 0) return null;
        // TreeNode root = new TreeNode(preorder[0]);
        // //int len = inorder.length;
        // int rootIndex = 0;
        // for (int i = 0; i < inorder.length; i++) {
        //     if (inorder[i] == preorder[0]) {
        //         rootIndex = i;
        //     }
        // }
        // root.left = build(root.left, inorder, 0, rootIndex - 1);
        // root.right = build(root.right, inorder, rootIndex + 1, preorder.length - 1);
        // return root;
    //}
    // public TreeNode build(TreeNode root, int[] inorder, int start, int end) {
    //     if (start > end) {
    //         return null;
    //     }
        
    //     int mid = start + (end - start) / 2;
    //     root = new TreeNode(inorder[mid]);
    //     root.left = build(root.left, inorder, start, mid - 1); 
    //     root.right = build(root.right, inorder, mid + 1, end);
    //     return root;
    // }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1, 0);
    }
    public TreeNode build(int[] preorder, int[] inorder, int start, int end, int preStart) {
        if (preStart > preorder.length - 1 || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
            }
        }
        root.left = build(preorder, inorder, start, rootIndex - 1, preStart + 1);
        root.right = build(preorder, inorder, rootIndex + 1, end, preStart + rootIndex - start + 1);
        return root;
    }
}