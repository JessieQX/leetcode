public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        wordList.add(endWord);
        bfs(neighbors, distance, beginWord, endWord, wordList);
        List<List<String>> result = new ArrayList<>();
        dfs(neighbors, distance, endWord, beginWord, wordList, result, new LinkedList<>());
        return result;
    }
    private void bfs(Map<String, List<String>> neighbors, Map<String, Integer> distance, String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (String nextWord : getNeighbors(word, dict)) {
                if (!neighbors.containsKey(nextWord)) {
                    neighbors.put(nextWord, new ArrayList<>());
                }
                neighbors.get(nextWord).add(word);
                if (distance.containsKey(nextWord)) {
                    continue;
                }
                distance.put(nextWord, distance.get(word) + 1);
                queue.offer(nextWord);
            }
        }
    }
    private void dfs(Map<String, List<String>> neighbors, Map<String, Integer> distance, String start, String end, Set<String> dict, List<List<String>> result, List<String> path) {
        path.add(0, start);
        if (start.equals(end)) {
            result.add(new LinkedList<>(path));
        } else {
            if (!neighbors.containsKey(start)) {
                return;
            }
            for (String nextWord : neighbors.get(start)) {
                if (distance.get(start) == distance.get(nextWord) + 1) {
                    dfs(neighbors, distance, nextWord, end, dict, result, path);
                }
            }
        }
        path.remove(0);
    }
    private static List<String> getNeighbors(String word, Set<String> wordList) {
        List<String> neighborList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) continue;
                String neighbor = replace(word, i, c);
                if (wordList.contains(neighbor)) {
                    neighborList.add(neighbor);
                }
            }
        }
        return neighborList;

    }
    private static String replace(String s, int i, char c) {
        char[] chars = s.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
}