public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        return helper(res, word, "", 0, 0);
    }
    private List<String> helper(List<String> res, String word, String curr, int pos, int count) {
        if (pos == word.length()) {
            curr = curr + count;
            res.add(curr);
            return res;
        } else {
            helper(res, word, curr, pos + 1, count + 1);
            helper(res, word, curr + (count > 0 ? count : ""), pos + 1, 0);
        }
    }
}