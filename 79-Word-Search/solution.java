public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (exist(board, word, x, y, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean exist(char[][] board, String word, int x, int y, int i) {
        if (i == word.length()) return true;
        if (x < 0 || y < 0 || x = board.length || y = board[x].length || board[x][y] != word.charAt(i)) {
            return false;
        }
        board[x][y] = '*';
        boolean result = exist(board, word, x + 1, y, i + 1)
                         || exist(board, word, x - 1, y, i + 1) 
                         || exist(board, word, x, y + 1, i + 1) 
                         || exist(board, word, x, y - 1, i + 1); 
                         
        board[x][y] = word.charAt(i);
        return result;
    }
}