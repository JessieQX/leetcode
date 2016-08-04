public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colB = B[0].length;
        int M = A[0].length;
        int[][] AB = new int[rowA - 1][colB - 1];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; i < colB; j++) {
                AB[i][j] = 0;
            }
        }
        //int k = 0;
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                int k = 0;
                while (k < M) {
                    AB[i][j] += A[i][k++] * B[k++][j];
                }
            }
        }
        return AB;
    }
}