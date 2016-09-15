public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }
    private void helper(List<String> res, String str, int left, int right, int size) {
        if (str.length() == size * 2) {
            res.add(str);
            return;
        }
        if (left < size) {
            helper(res, str + "(", left + 1, right, size);
        }
        if (right < left) {
            helper(res, str + ")", left, right + 1, size);
        }
    }
}