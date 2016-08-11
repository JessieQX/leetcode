public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permuteHelper(res, nums, 0);
        return res;
    }
    private void permuteHelper(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[start] == nums[i]) {
                continue;
            }
            swap(nums, start, i);
            permuteHelper(res, Arrays.copyof(nums, nums.length), start + 1);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}