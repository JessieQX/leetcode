public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            int m = nums[i + 1];
            int n = nums[nums.length - 1];
            int min = Integer.MAX_VALUE;
            int result = 0;
            while (m < n) {
                int x = sum - m - n;
                min = Math.min(Math.abs(x), min);
                if (min == Math.abs(x)) {
                    result = x;
                }
                m++;
                n--;
            }
        }
        return result;
    }
}