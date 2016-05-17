public class Solution {
    // public boolean exist(char[][] board, String word) {
    //     for (int x = 0; x < board.length; x++) {
    //         for (int y = 0; y < board[x].length; y++) {
    //             if (exist(board, word, x, y, 0)) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    // private boolean exist(char[][] board, String word, int x, int y, int i) {
    //     if (i == word.length()) return true;
    //     if (x < 0 || y < 0 || x = board.length || y = board[x].length || board[x][y] != word.charAt(i)) {
    //         return false;
    //     }
    //     board[x][y] = '*';
    //     boolean result = exist(board, word, x + 1, y, i + 1)
    //                      || exist(board, word, x - 1, y, i + 1) 
    //                      || exist(board, word, x, y + 1, i + 1) 
    //                      || exist(board, word, x, y - 1, i + 1); 
                         
    //     board[x][y] = word.charAt(i);
    //     return result;
    // }
    public boolean exist(char[][] board, String word) {
        //char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, String word, int i) {
        if (i == word.length()) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word.charAt(i)) return false;
        board[y][x] = '*';
        boolean exist = exist(board, y, x+1, word, i+1)
            || exist(board, y, x-1, word, i+1)
            || exist(board, y+1, x, word, i+1)
            || exist(board, y-1, x, word, i+1);
        board[y][x] = word.charAt(i);
        return exist;
    }
}