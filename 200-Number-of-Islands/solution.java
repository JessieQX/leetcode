public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) return -1;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
    private void helper(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        helper(grid, i + 1, j, m, n);
        helper(grid, i - 1, j, m, n);
        helper(grid, i, j + 1, m, n);
        helper(grid, i, j - 1, m, n);
    }
}