public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // if (triangle == null || triange.length == 0 || triange[0].length == 0) {
        //     return -1;
        // }
        // int n = triange.length;
        // int[][] f = new int[n][n];
        
        // f[0][0] = triangle[0][0];
        // for (int i = 1; i < n; i++) {
        //     f[i][0] = f[i - 1][0] + triangle[i][0];
        //     f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        // }
        // for (int i = 1; i < n; i++) {
        //     for (int j = 1; j < n; j++) {
        //         f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle[i][j];
        //     }
        // }
        // int best = f[n - 1][0];
        // for (int i = 1; i < n; i++) {
        //     best = Math.max(best, f[n - 1][i]);
        // }
        // return best;
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                List<Integer> f = triangle.get(i + 1);
                int sum = Math.min(f.get(j), f.get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, sum);
            }
        }
        return triangle.get(0).get(0);
    }
}