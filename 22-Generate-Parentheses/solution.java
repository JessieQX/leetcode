public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n * 2);
        return res;
    }
    private void helper(List<String> res, String str, int left, int right, int size) {
        if (str.length() == size) {
            res.add(str);
            return;
        }
        if (left < max) {
            helper(res, str + "(", left + 1, right, size);
        }
        if (right < left) {
            helper(res, str + ")", left, right + 1, size);
        }
    }
}