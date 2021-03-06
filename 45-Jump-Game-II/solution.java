public class Solution {
    public int jump(int[] nums) {
        // int[] steps = new int[nums.length];
        // steps[0] = 0;
        // for (int i = 1; i < nums.length; i++) {
        //     steps[i] = Integer.MAX_VALUE;
        //     for (int j = 0; j < i; j++) {
        //         if (steps[j] != Integer.MAX_VALUE && nums[j] + j >= i) {
        //             steps[i] = steps[j] + 1;
        //             break;
        //             //steps[i] = Math.min(steps[j] + 1, steps[i]);
        //         }
        //     }
        // }
        // return steps[nums.length - 1];
        int step_count = 0;
        int last_jump_max = 0;
        int current_jump_max = 0;
        for(int i=0; i<nums.length-1; i++) {
            current_jump_max = Math.max(current_jump_max, i+nums[i]);
            if( i == last_jump_max ) {
                step_count++;
                last_jump_max = current_jump_max;
            } 
        }
        return step_count;
    }
}