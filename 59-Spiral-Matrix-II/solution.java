public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int end = n - 1;
        int count = 1;
        while (left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count++;
            }
            top++;
            for (int i = top; i <= end; i++) {
                matrix[i][right] = count++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[end][i] = count++;
            }
            end--;
            for (int i = end; i >= top; i--) {
                matrix[i][left] = count++;
            }
            left++;
        }
        return matrix;
    }
}