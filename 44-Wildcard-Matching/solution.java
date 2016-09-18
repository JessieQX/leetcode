public class Solution {
    public boolean isMatch(String s, String p) {
        //if (s.isEmpty() && p.isEmpty()) return true;
        //if ((s.isEmpty() || p.isEmpty()) && (s.equals("*") || p.equals("*"))) return true;
        //if (s.isEmpty() || p.isEmpty()) return false;
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                f[0][j] = f[0][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    f[i][j] = f[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    
                        f[i][j] = f[i - 1][j - 1] || f[i - 1][j] || f[i][j - 1];
                    
                }
                
            }
        }
        return f[m][n];
    }
}