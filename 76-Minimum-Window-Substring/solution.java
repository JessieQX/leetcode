public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        String res = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        int start = 0, end = 0, count = 0, len = Integer.MAX_VALUE, left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count++;
                }
            }
            if (count == t.length()) {
                end = i;
                while (!map.containsKey(s.charAt(start))) {
                    start++;
                }
                int dist = end - start + 1;
                if (dist < len) {
                    len = dist;
                    left = start;
                }
                start++;
                if (start >= s.length()) break;
                map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                count--;
            }
        }
        res = s.substring(left, left + len);
        return res;
    }
}