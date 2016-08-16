public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int index = 1;
        wordList.add(endWord);
        while (!queue.isEmpty()) {
            index++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String s : getNeighbor(word, wordList)) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return index;
                    }
                    visited.add(s);
                    queue.add(s);
                }
            }
        }
        return 0;
    }
    private List<String> getNeighbor(String word, Set<String> wordList) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) continue;
                String neighbor = replace(word, i, c);
                if (wordList.contains(neighbor)) {
                    list.add(neighbor);
                }
            }
        }
        return list;
    }
    private String replace(String word, int i, char c) {
        char[] chars = word.toCharArray();
        chars[i] = c;
        //word.charAt(i) = c;
        return new String(chars);
    }
}