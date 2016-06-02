public class Solution {
    public int coinChange(int[] coins, int amount) {
        // if (coins == null || coins.length == 0) {
        //     return -1;
        // }
        // if (amount <= 0) {
        //     return 0;
        // }
        // Arrays.sort(coins);
        // // if (coins[0] > amount) {
        // //     return -1;
        // // }
        // int[] f = new int[amount + 1];
        // f[0] = 0;
        // for (int i = 1; i <= amount; i++) {
        //     int j = 0;
        //     int min = Integer.MAX_VALUE;
        //     if (i - coins[j] < 0) {
        //         min = -1;
        //     }
        //     while (j < coins.length && i - coins[j] >= 0) {
        //         if (f[i - coins[j]] == -1) {
        //             min = -1;
        //         } else {
        //             min = Math.min(min, f[i - coins[j]] + 1);
        //         }
        //         j++;
        //     }
        //     f[i] = min;
        // }
        // return f[amount];
        // if (coins == null || coins.length == 0)
        //     return -1;

        // if (amount <= 0)
        //     return 0;
            
        // int[] dp = new int[amount + 1];
        // for (int i = 1; i < amount + 1; i++) {
        //     dp[i] = Integer.MAX_VALUE;
        // }
        // dp[0] = 0;
        // for (int i = 1; i < amount + 1; i++) {
        //     for (int j = 0; j < coins.length; j++) {
        //         if (i - coins[j] >= 0) {
        //             dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        //         }
        //     }
        // }
        // return dp[amount] > amount ? -1 : dp[amount];
        if (coins == null || coins.length == 0)
            return -1;

        if (amount <= 0)
            return 0;

        int dp[] = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int am = 1; am < dp.length; am++) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= am) {
                    int sub = dp[am - coins[i]];
                    if (sub != Integer.MAX_VALUE && sub + 1 < dp[am])
                        dp[am] = sub + 1;
                }
            }
        }
        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }
}