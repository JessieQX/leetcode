public class Solution {
    public int minPatches(int[] nums, int n) {
        long edge = 1;
        int count = 0, i = 0;
        while (edge <= n) {
            if (i < nums.length && nums[i] <= edge) {
                edge += nums[i++];
            } else {
                edge += edge;
                count++;
            }
        }
        return count;
    }
}