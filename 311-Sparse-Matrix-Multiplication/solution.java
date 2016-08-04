public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length - 1;
        int colB = B[0].length - 1;
        int M = A[0].length - 1;
        int[][] AB = new int[rowA][colB];
        //int k = 0;
        for (int i = 0; i <= rowA; i++) {
            for (int j = 0; j <= colB; j++) {
                int k = 0;
                while (k <= M) {
                    AB[i][j] += A[i][k++] * B[k++][j];
                }
            }
        }
        return AB;
    }
}