public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, res, new ArrayList<>(), target, 0);
    }
    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> list, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        } else if (target > 0) {
            for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                list.add(candidates[i]);
                helper(candidates, res, list, target - nums[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
}