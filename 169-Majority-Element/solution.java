public class Solution {
    public int majorityElement(int[] nums) {
        // Arrays.sort(nums);
        // int len = nums.length;
        // return nums[len/2];
        
        //是它就＋1，不是它就－1
        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;

        }
        return major;
    }
}