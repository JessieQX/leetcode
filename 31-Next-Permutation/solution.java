public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null) return;
        if (nums.length < 2) return;
        int n = nums.length;
        int index = n - 1;
        while (index > 0) {
            if (nums[index] > nums[index - 1]) {
                break;
            }
            index--;
        }
        if (index == 0) reverseSort(nums, 0, n - 1);
        else {
            int j = n - 1;
            while (j >= index) {
                if (nums[j] > nums[index - 1]) {
                    break;
                }
                j--;
            }
            swap(nums, j, index - 1);
            reverseSort(nums, index, n - 1);
            return;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverseSort(int[] nums, int start, int end) {
        if (start > end) return;
        for (int i = start; i <= (start + end) / 2; i++) {
            swap(nums, i, start + end - i);
        }
    }
}