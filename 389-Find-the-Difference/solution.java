public class Solution {
    public char findTheDifference(String s, String t) {
        // Map<Character, Integer> map = new HashMap<>();
        // char res = ' ';
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (!map.containsKey(c)) {
        //         map.put(c, 1);
        //     } else {
        //         map.put(c, map.get(c) + 1);
        //     }
        // }
        // for (int j = 0; j < t.length(); j++) {
        //     char c = t.charAt(j);
        //     if (!map.containsKey(c)) {
        //         res = c;
        //         break;
        //     } else {
        //         map.put(c, map.get(c) - 1);
        //         if (map.get(c) == 0) {
        //             map.remove(c);
        //         }
        //     }
        // }
        // return res;
        int[] res = new int[26];
        for (int i = 0; i < 26; i++) res[i] = 0;
        for (char c : s.toCharArray()) {
            res[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            res[c - 'a']--;
            if (res[c - 'a'] < 0) {
                return c;
            }
        }
        return 0;
    }
}