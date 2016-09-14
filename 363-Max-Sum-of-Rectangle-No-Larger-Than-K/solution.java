public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // if (matrix.length == 0 || matrix[0].length == 0) {
        //     return 0;
        // }
        // int res = Integer.MIN_VALUE;
        // int m = matrix.length;
        // int n = matrix[0].length;
        
        // for (int left = 0; left < n; left++) {
        //     int[] sums = new int[m];
        //     for (int right = left; right < n; right++) {
        //         for (int i = 0; i < m; i++) {
        //             sums[i] += matrix[i][right];
        //         }
        //         Set<Integer> set = new TreeSet<>();
        //         set.add(0);
        //         int currSum = 0;
        //         for (int sum : sums) {
        //             currSum += sum;
        //             Integer num = set.ceiling(currSum - k);
        //             if (num != null) res = Math.max(res, currSum - num);
        //             set.add(currSum);
        //         }
        //     }
        // }
        // return res;
        if(matrix.length == 0) return 0;
    
    int m = matrix.length, n = matrix[0].length;
    int result = Integer.MIN_VALUE;
    
    //outer loop should use smaller axis
    //now we assume we have more rows than cols, therefore outer loop will be based on cols 
    for(int left = 0; left < n; left++){
        //array that accumulate sums for each row from left to right 
        int[] sums = new int[m];
        for(int right = left; right < n; right++){
            //update sums[] to include values in curr right col
            for(int i = 0; i < m; i++){
                sums[i] += matrix[i][right];
            }
            
            //we use TreeSet to help us find the rectangle with maxSum <= k with O(logN) time
            TreeSet<Integer> set = new TreeSet<Integer>();
            //add 0 to cover the single row case
            set.add(0);
            int currSum = 0;
            
            for(int sum : sums){
                currSum += sum;
                //we use sum subtraction (curSum - sum) to get the subarray with sum <= k
                //therefore we need to look for the smallest sum >= currSum - k
                Integer num = set.ceiling(currSum - k);
                if(num != null) result = Math.max( result, currSum - num );
                set.add(currSum);
            }
        }
    }
    
    return result;
    }
}