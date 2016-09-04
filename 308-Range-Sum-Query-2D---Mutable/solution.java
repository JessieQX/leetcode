public class NumMatrix {
    private int[][] matrix;
    private int[][] nums;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = matrix[i][j];
            }
        }
    }

    public void update(int row, int col, int val) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return;
        }
        nums[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += nums[i][j];
            }
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);