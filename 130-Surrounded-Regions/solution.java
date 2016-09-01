public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    helper(board, i, j, m, n);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void helper(char[][] board, int i, int j, int m, int n) {
        // if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
        // board[i][j] = '1';
        // helper(board, i - 1, j, m, n);
        // helper(board, i + 1, j, m, n);
        // helper(board, i, j - 1, m, n);
        // helper(board, i, j + 1, m, n);
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            if (i > 1) helper(board, i - 1, j, m, n);
            if (i + 1 < m) helper(board, i + 1, j, m, n);
            if (j > 1) helper(board, i, j - 1, m, n);
            if (j + 1 < n) helper(board, i, j + 1, m, n);
        }
    }
}