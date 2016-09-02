public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        for (int[] edge : edges) {
            int x = find(nums, edge[0]);
            int y = find(nums, edge[1]);
            if (x != y) {
                nums[x] = y;
                n--;
            }
        }
        return n;
    }
    private int find(int[] nums, int i) {
        while (nums[i] != i) {
            nums[i] = nums[nums[i]];
            i = nums[i];
        }
        return i;
    }
}