public class Solution {
    public void moveZeroes(int[] nums) {
        //有几个0往前移几个
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else if (nums[i] != 0) {
                nums[i - count] = nums[i];
            }
        }
        for (int i = 0; i < count; i++) {
            nums[nums.length - count + i] = 0;
        }
    }
}