public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colB = B[0].length;
        int M = A[0].length;
        int[][] AB = new int[rowA][colB];
        
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < M; k++) {
                    if (A[i][k] != 0 && B[k][j] != 0) {
                        AB[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return AB;
    }
}