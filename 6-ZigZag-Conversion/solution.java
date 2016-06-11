public class Solution {
    public String convert(String s, int numRows) {
        int chunk = Math.max(2 * numRows - 2, numRows);
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int i = 0; i < s.length(); i += chunk) {
                if (i + row < s.length()) {
                    sb.append(s.charAt(i + row));
                }
                if (row > 0 && row + 1 < numRows && i + chunk - row < s.length()) {
                    sb.append(s.charAt(i + chunk - row));
                }
            }
        }
        return sb.toString();
    }
}