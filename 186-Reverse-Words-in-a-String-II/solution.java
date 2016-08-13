public class Solution {
    public void reverseWords(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            if (i < j && s.charAt(i) == " ") {
                i++;
            }
            if (i < j && s.charAt(j) == " ") {
                j--;
            }
            swap(s, s[i], s[j]);
            i++;
            j--;
        }
    }
    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}