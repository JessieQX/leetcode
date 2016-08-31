public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] res = new int[26];
        for (int i = 0; i < 26; i++) {
            res[i] = 0;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (res[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}