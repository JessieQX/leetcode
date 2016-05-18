public class Solution {
    public int search(int[] nums, int target) {
        int minIdx = findMinIdx(nums);
        if (target == nums[minIdx]) {
            return minIdx;
        }
        int len = nums.length;
        int start = (target <= nums[len - 1]) ? minIdx : 0;
        int end = (target > num[len - 1]) ? minIdx : len - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    private int findMinIdx(int[] nums) {
        int start = 0, end = nums - 1;
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