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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        queue.push(q);
        queue.push(0);
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            TreeNode node = queue.poll();
            int col = cols.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);
            if (node.left != null) {
                queue.push(node.left);
                cols.push(col - 1);
                if (col <= min) min = col - 1;
            }
            if (node.right != null) {
                queue.push(node.right);
                cols.push(col + 1);
                if (col >= max) max = col + 1;
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}