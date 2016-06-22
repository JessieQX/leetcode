public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        List<Integer> level = new ArrayList<>();
        helper(res, level, n, k, 1);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> level, int n, int k, int start) {
        if (level.size() == k) {
            res.add(new ArrayList<>(level));
            return;
        }
        for (int i = start; i <= n; i++) {
            level.add(i);
            helper(res, level, n, k, i + 1);
            level.remove(level.size() - 1);
        }
    }
}