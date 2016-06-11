public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        boolean[] can = new boolean[s.length() + 1];
        can[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            can[i] = false;
            for (int j = 1; j <= i && j <= maxLength(wordDict); j++) {
                if (!can[i - j]) continue;
                if (wordDict.contains(s.substring(i - j, i))) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[s.length()];
    }
    private int maxLength(Set<String> wordDict) {
        int max = 0;
        for (String s : wordDict) {
            int len = s.length();
            max = Math.max(len, max);
        }
        return max;
    }
}