public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j < len2 + 1; j++) {
            f[0][j] = j;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1), f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[len1][len2];
    }
}