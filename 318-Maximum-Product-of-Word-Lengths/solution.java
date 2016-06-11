public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!shareCommonLetter(words[i], words[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
    private boolean shareCommonLetter(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        for (int j = 0; j < s2.length(); j++) {
            if (set.contains(s2.charAt(j))) {
                return true;
            }
        }
        return false;
    }
}