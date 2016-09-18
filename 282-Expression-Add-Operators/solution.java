public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }
    private void helper(List<String> res, String path, String num, int target, int start, long val, long multed) {
        if (start == num.length()) {
            if (val == target) {
                res.add(path);
                return;
            }
        }
        for (int i = start; i < num.length(); i++) {
            if (i != start && num.charAt(start) == '0') break;
            long curr = Long.parseLong(num.substring(start, i + 1));
            if (start == 0) {
                helper(res, path + curr, num, target, i + 1, curr, curr);
            } else {
                helper(res, path + "+" + curr, num, target, i + 1, val + curr, curr);
                helper(res, path + "-" + curr, num, target, i + 1, val - curr, -curr);
                helper(res, path + "*" + curr, num, target, i + 1, val - multed + multed * curr, multed * curr);
            }
        }
    }
}