public class Solution {
    public int findMin(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            }
        }
        return nums[count + 1];
    }
}