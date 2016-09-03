public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        if (s.length() == 1) return 1;
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            String res = getSubstring(s, k, i);
            sum = Math.max(sum, res.length());
        }
        return sum;
    }
    private String getSubstring(String s, int k, int start) {
        String res = "";
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count > k) break;
            if (!map.containsKey(c)) {
                map.put(c, 1);
                count++;
                if (count <= k) {
                    res = s.substring(start, i + 1);
                }
            } else {
                map.put(c, map.get(c) + 1);
                if (count <= k) {
                    res = s.substring(start, i + 1);
                }
            }
        }
        return res;
    }
}