public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            String ss = new String(s);
            if (ss.charAt(i - 1) == ss.charAt(i) && ss.charAt(i) == '+') {
                ss.charAt(i - 1) = '-';
                ss.charAt(i) = '-';
                res.add(ss);
                continue;
            }
        }
        return res;
    }
}