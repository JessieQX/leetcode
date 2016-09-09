public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid1 = start + (end - start) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) {
                start = mid2;
            } else {
                end = mid1;
            }
        }
        return start;
    }
}