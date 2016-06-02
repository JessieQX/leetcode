public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] f = new int[amount + 1];
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int j = 0;
            int min = Integer.MAX_VALUE;
            while (i - coins[j] >= 0 && j < coins.length) {
                min = Math.min(min, f[i - coins[j]] + 1);
                j++;
            }
            f[i] = min;
        }
        return f[amount];
    }
}