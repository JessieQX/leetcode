public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return false;
        String[] ss = preorder.split(",");
        int diff = 1;
        for (String s : ss) {
            if (--diff < 0) return false;
            if (!s.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}