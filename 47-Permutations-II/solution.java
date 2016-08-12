public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permuteHelper(nums, res, list, visited);
        return res;
    }
    private void permuteHelper(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            permuteHelper(nums, res, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}