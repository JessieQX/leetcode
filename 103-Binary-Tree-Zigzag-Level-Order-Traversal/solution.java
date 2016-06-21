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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> level = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean can = true;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            level.add(node.val);
            if (can) {
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
                //can = !can;
            // } else {
            //     if (root.left != null) {
            //         stack.push(root.left);
            //     }
            //     if (root.right != null) {
            //         stack.push(root.right);
            //     }
            //     can = !can;
             }
            res.add(level);
        }
        return res;
    }
}