public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            if (helper(nums, i, k, t)) {
                return true;
            }
        }
        return false;
    }
    private boolean helper(int[] nums, int m, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return false;
        }
        for (int i = m + 1; i <= Math.min((m + k), nums.length - 1); i++) {
            if (Math.abs(nums[i] - nums[m]) <= t) {
                return true;
            }
        }
        return false;
    }
}