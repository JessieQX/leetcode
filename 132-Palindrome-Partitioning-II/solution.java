public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        boolean[][] isPalindrome = isPalindrome(s);
        int[] f = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            f[i] = i - 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[n];
    }
    private boolean[][] isPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int len = 2; len < n; len++) {
            for (int start = 0; start + len < n; start++) {
                isPalindrome[start][start + len] = isPalindrome[start + 1][start + len - 1] && s.charAt(start) == s.charAt(start + len);
            }
        }
        return isPalindrome;
    }
}