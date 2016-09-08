public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }
}