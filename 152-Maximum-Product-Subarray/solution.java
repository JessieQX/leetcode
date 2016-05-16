public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int product = 1;
        int maxProduct = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                product *= nums[i] * nums[i - 1];
            } else {
                product = 1;
            }
            maxProduct = Math.max(maxProduct, product);
        }
    }
}