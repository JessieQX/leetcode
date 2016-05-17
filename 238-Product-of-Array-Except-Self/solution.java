public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result = helper(nums, i);
        }
        return result;
    }
    private int[] helper(int[] nums, int m) {
        int[] res = new int[nums.length];
        nums[m] = 1;
        for (int i = 0; i < nums.length; i++) {
            res[m] = res[m] * nums[i];
        }
        return res;
    }
}