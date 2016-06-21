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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //res.add(root.val);
        while (!stack.isEmpty()) {
            int size = stack.size();
            int i = 0;
            while (i < size) {
                TreeNode node = stack.pop();
                if (i == 0) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                i++;
            }
        } 
        
    }
}