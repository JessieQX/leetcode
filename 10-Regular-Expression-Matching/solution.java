public class Solution {
    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) return false;
        if (!p.isEmpty() && p.charAt(0) == '*') return false;
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 1; i <= m; i++) {
            f[i][0] = false;
        }
        for (int j = 1; i < n; j++) {
            if (p.charAt(j) == '*') {
                f[0][j + 1] = f[0][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    f[i][j] = f[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || '.' == p.charAt(j - 1));
                } else {
                    f[i][j] = f[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || '.' == p.charAt(j - 2)) && f[i - 1][j];
                }
            }
        }
        return f[m][n];
    }
}