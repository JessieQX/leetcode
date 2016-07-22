public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            String ss = s;
            if (s.charAt(i - 1) == s.charAt(i) == '+') {
                ss.charAt(i - 1) = '-';
                ss.charAt(i) = '-';
                res.add(ss);
                continue;
            }
        }
        return res;
    }
}