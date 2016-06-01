public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            if (f[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                f[i][0] = true;
            }
        }
        for (int j = 1; j < n + 1; j++) {
            if (f[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1)) {
                f[0][j] = true;
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[i - 1][j] ||
                s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[i][j - 1]) {
                    f[i][j] = true;
                } 
            }
        }
        return f[m][n];
    }
}