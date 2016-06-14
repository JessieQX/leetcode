public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 2) {
            return -1;
        }
        Arrays.sort(nums);
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            int m = i + 1;
            int n = nums.length - 1;
            
            while (m < n) {
                int x = sum - nums[m] - nums[n];
                min = Math.min(Math.abs(x), min);
                if (min == Math.abs(x)) {
                    result = target - x;
                }
                if (x > 0) m++;
                if (x < 0) n--;
                if (x == 0) return result;
            }
        }
        return result;
    }
}