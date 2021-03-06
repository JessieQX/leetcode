public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        //boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permuteHelper(nums, res, list);
        return res;
    }
    private void permuteHelper(int[] nums, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            permuteHelper(nums, res, list);
            list.remove(list.size() - 1);
        }
    }
}