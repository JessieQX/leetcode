public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            n = n / 5;
            res = res + n;
        }
        return res;
    }
}