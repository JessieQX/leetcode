public class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            f[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n + 1; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(min, f[i - j * j] + 1);
                j++;
            }
            f[i] = min;
        }
        return f[n];
    }
}