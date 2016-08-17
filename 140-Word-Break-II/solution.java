public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        helper(s, wordDict, res, "", 0);
        return res;
    }
    private void helper(String s, Set<String> wordDict, List<String> res, String str, int start) {
        if (start == s.length()) {
            res.add(new String(str.substring(0, str.length() - 1)));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (wordDict.contains(s.substring(start, i + 1))) {
                str += s.substring(start, i + 1) + " ";
                helper(s, wordDict, res, str, i + 1);
                str -= (s.substring(start, i + 1) + " "); 
            }
            
        }
    }
}