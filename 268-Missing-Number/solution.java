public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0 && nums.length > 1 || nums.length == 1 && nums[0] == 1) {
            return 0;
        } 
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                break;
            }
        }
        //return count + 2;
        
        return nums[count] + 1;
        
    }
}