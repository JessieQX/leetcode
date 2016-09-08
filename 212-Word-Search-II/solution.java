public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        //List<String> res = new ArrayList<>();
        Set<String> res = new HashSet<>();
        TrieNode trie = new TrieNode();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie, res, "");
            }
        }
        return new ArrayList<>(res);
    }
    private void dfs(char[][] board, int i, int j, TrieNode node, Set<String> res, String str) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        if (board[i][j] == '#') return;
        str += board[i][j];
        if (!node.startsWith(str)) return;
        if (node.search(str)) {
            res.add(str);
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, node, res, str);
        dfs(board, i + 1, j, node, res, str);
        dfs(board, i, j - 1, node, res, str);
        dfs(board, i, j + 1, node, res, str);
        board[i][j] = c;
    }
}
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String name = "";
    
    public void insert(String word) {
        TrieNode node = this;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.name = word;
    }
    
    public boolean search(String word) {
        TrieNode node = this;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.name.equals(word);
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = this;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}