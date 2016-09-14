public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int left = 0; left < n; left++) {
            int[] sums = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    sums[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int currSum = 0;
                for (int sum : sums) {
                    currSum += sum;
                    Integer num = set.ceiling(currSum - k);
                    if (num != null) res = Math.max(res, currSum - num);
                    set.add(currSum);
                }
            }
        }
        return res;
        
    }
}