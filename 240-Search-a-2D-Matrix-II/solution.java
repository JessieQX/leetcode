public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            int start = matrix[i][0], end = matrix[i][col - 1];
            for (int j = 0; j < col; j++) {
                while (start < end) {
                    int mid = start + (end - start) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    }
                    if (matrix[i][mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                if (matrix[i][start] == target) {
                    return true;
                }
                if (matrix[i][end] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}