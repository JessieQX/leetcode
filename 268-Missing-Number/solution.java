public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                break;
            }
        }
        return nums[count + 1];
    }
}