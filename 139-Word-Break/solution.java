public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        boolean[] can = new boolean[s.length() + 1];
        can[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            can[i] = false;
            for (int j = 1; j <= i && j <= maxLength(wordDict); j++) {
                if (!can[i - j]) break;
                if (wordDict.contains(s.substring(i - j, j))) {
                    can[i] = true;
                    break;
                }
            }
        }
        return false;
    }
    private int maxLength(Set<String> wordDict) {
        int max = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            int len = wordDict.get(i).length();
            max = Math.max(len, max);
        }
        return max;
    }
}