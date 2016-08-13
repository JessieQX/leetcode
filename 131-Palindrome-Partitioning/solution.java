public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s, res, list, 0);
        return res;
    }
    private void helper(String s, List<List<String>> res, List<String> list, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                helper(s, res, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome (String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}