public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return -1;
        }
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        int[] newWords = new int[words.length];
        for (int i = 0; i < newWords.length; i++) {
            for (Charater c : words[i].toCharArray()) {
                newWords[i] |= 1 << (c - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < newWords.length - 1; i++) {
            if (newWords[i].length() * newWords[i].length() <= max) break;
            for (int j = i + 1; j < newWords.length; j++) {
                if (newWords[i] & newWords[j] == 0) {
                    max = Math.max(max, newWords[i].length() * newWords[j].length());
                }
            }
        }
        return max;
    }
}