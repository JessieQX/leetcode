public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        boolean[] can = new boolean[s.length() + 1];
        can[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            can[i] = false;
            for (int j = 0; j < i; j++) {
                //if (!can[i - j]) continue;
                // if (can[i - j] && wordDict.contains(s.substring(i - j, i))) {
                //     can[i] = true;
                //     break;
                // }
                if (can[j] && wordDict.contains(s.substring(j, i))) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[s.length()];
    }
    
}