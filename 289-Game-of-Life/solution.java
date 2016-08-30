public class Solution {
    private static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1},{1, 1},{1, -1},{-1, 1},{-1, -1}};
    //2 means live to dead, 3 means dead to live
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = 0;
                for (int[] d : dir) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
                    if (board[x][y] == 1 || board[x][y] == 2) live++;
                }
                if (board[i][j] == 0 && live == 3) board[i][j] = 3;
                if (board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 2;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board %= 2;
            }
        }
    }
}