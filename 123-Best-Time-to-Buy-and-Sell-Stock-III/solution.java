public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit1 = 0;
        int maxProfit2 = 0;
        int minBuyPrice1 = Integer.MAX_VALUE;
        int minBuyPrice2 = Integer.MAX_VALUE;
        for (int p : prices) {
            maxProfit2 = Math.max(maxProfit2, p - minBuyPrice2);
            minBuyPrice2 = Math.min(minBuyPrice2, p - maxProfit1);
            maxProfit1 = Math.max(maxProfit1, p - minBuyPrice1);
            minBuyPrice1 = Math.min(minBuyPrice1, p);
        }
        return maxProfit2;
    }
}