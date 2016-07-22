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
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return res;
        helper(root);
        return res;
    }
    private int helper(TreeNode node) {
        if (node == null) return -1;
        int height = 1 + Math.max(helper(node.left), helper(node.right));
        if (res.size() < height + 1) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(node.val);
        return height;
    }
}