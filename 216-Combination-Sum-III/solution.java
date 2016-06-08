public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(result, curr, k, n, 1);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> curr, int k, int target, int start) {
        //int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //int count = 0;
        if (target > 0 && curr.size() < k) {
            for (int i = start; i <= 9; i++) {
                //if (i > start && candidates[i] == candidates[i - 1]) continue;
                curr.add(i);
                helper(result, curr, k, target - i, i + 1);
                curr.remove(curr.size() - 1);//if the result is right, it will turn to result.add() part; if it turns to curr.remove() part, then the number is wrong, so we need to remove it from curr list.
            }
        } else if (target == 0 && curr.size() == k) {
            result.add(new ArrayList<Integer>(curr));
        } else {
            return;
        }
    }
}