public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(result, curr, candidates, target, 0);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> curr, int[] candidates, int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                curr.add(candidates[i]);
                helper(result, curr, candidates, target - candidates[i], i + 1);
                curr.remove(curr.size() - 1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<Integer>(curr));
        }
    }
}