public class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        int count = helper(s, 1, 0);
        if (count % 2 != 0) {
            return true;
        }
        return false;
    }
    private int helper(String s, int start, int count) {
        if (start == s.length() - 1) {
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
                helper(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()), start + 1, count + 1);
            }
        }
        return count;
    }
}