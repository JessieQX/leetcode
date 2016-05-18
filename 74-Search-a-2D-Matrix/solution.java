public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int targetRow = searchRow(matrix, target);
        int start = 0, end = col - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            }
            if (matrix[targetRow][mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (matrix[targetRow][start] == target || matrix[targetRow][end] == target) {
            return true;
        }
        return false;
    }
    private int searchRow(int[][] matrix, int target) {
        int row = matrix.length;
        
        int start = 0, end = row - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return mid;
            }
            if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}