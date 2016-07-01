public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int n = nums.length;
        int i = 0;
        int j = 1;
        int count = 1;
        while (i < n) {
            int major = nums[i];
            if (j >= n && count < n / 3) {
                i = i + 1;
                j = i + 1;
                count = 1;
            }
            if (major == nums[j++]) {
                count++;
            }
            
            if (j < n && count >= n / 3) {
                list.add(major);
                i = i + 1;
                j = i + 1;
                count = 1;
            }
        }
        return list;
    }
}