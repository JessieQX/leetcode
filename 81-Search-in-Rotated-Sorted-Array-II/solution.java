public class Solution {
    public boolean search(int[] nums, int target) {
        int midIdx = findMinIdx(nums);
        int len = nums.length;
        if (target == nums[midIdx]) {
            return true;
        }
        int start = (target <= nums[len - 1]) ? minIdx : 0;
        int end = (target > nums[len - 1]) ? minIdx : len - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target || nums[end] == target) {
            return true;
        }
        return false;
    }
    private int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}