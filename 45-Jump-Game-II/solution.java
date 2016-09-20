public class Solution {
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];
        steps[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && nums[j] + j >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                    //steps[i] = Math.min(steps[j] + 1, steps[i]);
                }
            }
        }
        return steps[nums.length - 1];
    }
}