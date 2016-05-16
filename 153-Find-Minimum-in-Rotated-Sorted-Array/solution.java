public class Solution {
    public int findMin(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                break;
            }
        }
        if (count == nums.length - 1) {
            return nums[0];
        } else {
            return nums[count + 1];
        }
    }
}