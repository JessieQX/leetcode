public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] f = new int[n];
        int res = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else if (c == ')' && left > 0) {
                f[i] = f[i - 1] + 2;
                if (i - f[i] > 0) {
                    f[i] += f[i - f[i]];
                }
                left--;
            }
            res = Math.max(res, f[i]);
        }
        return res;
    }
}