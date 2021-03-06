public class Solution {
    // public int threeSumSmaller(int[] nums, int target) {
    //     if (nums == null || nums.length == 0) return 0;
    //     Arrays.sort(nums);
    //     List<List<Integer>> res = new ArrayList<>();
    //     List<Integer> list = new ArrayList<>();
    //     helper(nums, target, 0, list, res);
    //     return res.size();
    // }
    // private void helper(int[] nums, int target, int start, List<Integer> list, List<List<Integer>> res) {
    //     if (list.size() == 3 && target > 0) {
    //         res.add(new ArrayList<>(list));
    //         return;
    //     }
    //     for (int i = start; i < nums.length; i++) {
    //         list.add(nums[i]);
    //         helper(nums, target - nums[i], i + 1, list, res);
    //         list.remove(list.size() - 1);
    //     }
    // }
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}