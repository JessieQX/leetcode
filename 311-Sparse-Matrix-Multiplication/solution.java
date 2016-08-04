public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colB = B[0].length;
        int M = A[0].length;
        int[][] AB = new int[rowA][colB];
        // for (int i = 0; i < rowA; i++) {
        //     for (int j = 0; j < colB; j++) {
        //         AB[i][j] = 0;
        //     }
        // }

        // for (int i = 0; i < rowA; i++) {
        //     for (int j = 0; j < colB; j++) {
        //         for (int k = 0; k < M; k++) {
        //             if (A[i][k] != 0 && B[k][j] != 0) {
        //                 AB[i][j] += A[i][k] * B[k][j];
        //             }
        //         }
        //     }
        // }
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < colB; k++) {
                        if (B[j][k] != 0) {
                            AB[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        return AB;
    }
}