public class Solution {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        return dp(f, 1, n);
    }
    private int dp(int[][] f, int i, int j) {
        if (i >= j) return 0;
        if (f[i][j] != 0) return f[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int temp = k + Math.max(dp(f, i, k - 1), dp(f, k + 1, j));
            int res = Math.min(temp, res);
        }
        f[i][j] = res;
        return res;
    }
}