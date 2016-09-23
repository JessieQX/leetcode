public class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        
        int[] chars = new int[26];
        for (char c = 'a'; c <= 'z'; c++) {
            chars[c - 'a'] = 0;
        }
        int n = 0;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                if (chars[c - 'a'] == 0) {
                    chars[c - 'a'] = 1;
                    n++;
                }
            }
        }
        
        char[][] order = new char[n][n];
        char[] indegree = new char[n];
        for (int k = 0; k < words.length - 1; k++) {
            String s1 = words[k];
            String s2 = words[k + 1];
            int i = 0, j = 0;
            while (i < s1.length() && j < s2.length()) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if (c1 == c2) {
                    i++;
                    j++;
                } else {
                    if (order[c1][c2] == 0) indegree[c2]++;
                    if (indegree[c2] > 1) return "";
                    order[c1][c2] = 1;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (chars[c - 'a'] == 1) {
                if (indegree[c] == 0) queue.offer(c);
            }
        }
        if (queue.size() == 0) return "";
        
        String res = "";
        while (!queue.isEmpty()) {
            char c = queue.poll();
            res += c;
            for (char m = 'a'; m <= 'z'; m++) {
                if (chars[m - 'a'] == 1) {
                    if (order[c][m] != 0) {
                        queue.offer(m);
                    }
                }
            }
        }
        return res;
    }
}