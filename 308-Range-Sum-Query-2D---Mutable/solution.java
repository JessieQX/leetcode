public class NumMatrix {
    private int[][] matrix;
    private int[][] nums;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        nums = new int[m + 1][n];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = nums[i - 1][j] + matrix[i - 1][j];
            }
        }
    }

    public void update(int row, int col, int val) {
        for (int i = row + 1; i < nums.length; i++) {
            nums[i][col] = nums[i][col] - matrix[row][col] + val;
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = col1; i <= col2; i++) {
            sum += nums[row2 + 1][i] - nums[row1][i];
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);