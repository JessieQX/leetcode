public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, "", 0, 0);
        return res;
    }
    private void helper(List<String> res, String word, String curr, int pos, int count) {
        if (pos == word.length()) {
            if (count > 0) {
                curr = curr + count;
            }
            res.add(curr);
        } else {
            helper(res, word, curr, pos + 1, count + 1);//count the character that needs to be abbreviated
            helper(res, word, curr + (count > 0 ? count : "") + word.charAt(pos), pos + 1, 0);//make the count into abbreviation and set the count 0.
        }
    }
}