public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        //longer words are at front.
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        //newWords is to turn String into Integer so we can figure out whether they have same characters.
        int[] newWords = new int[words.length];
        for (int i = 0; i < newWords.length; i++) {
            for (Character c : words[i].toCharArray()) {
                newWords[i] |= 1 << (c - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < newWords.length - 1; i++) {
            
            //if words[i].length is not long enough, then break.
            if (words[i].length() * words[i].length() <= max) break;
            for (int j = i + 1; j < newWords.length; j++) {
                
                //compare whether two Strings have same characters.
                if ((newWords[i] & newWords[j]) == 0) {
                    //still use words[i] to multiple the length.
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}