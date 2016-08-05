public class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
                String ss = s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length());
                if (!canWin(ss)) {
                    return true;
                }
            }
        }
        return false;
    }
}