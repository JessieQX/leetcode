public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int step = 0, step1 = 1, step2 = 1;
        for (int i = 2; i <= n; i++) {
            step = step1 + step2;
            step2 = step1;
            step1 = step;
        }
        return step;
    }
}