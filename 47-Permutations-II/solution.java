public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permuteHelper(res, list, nums, visited);
        return res;
    }
    private void permuteHelper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            permuteHelper(res, list, nums, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}