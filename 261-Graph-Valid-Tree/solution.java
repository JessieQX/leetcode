public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        for (int[] edge : edges) {
            int x = findUnion(nums, edge[0]);
            int y = findUnion(nums, edge[1]);
            if (x == y) return false;
            nums[x] = y;
        }
        return edges.length == n - 1;
    }
    private int findUnion(int[] nums, int i) {
        if (nums[i] == -1) {
            return i;
        }
        return findUnion(nums, nums[i]);
    }
}