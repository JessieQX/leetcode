public class Solution {
    public void reverseWords(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            if (i < j && s[i] == ' ') {
                i++;
            }
            if (i < j && s[j] == ' ') {
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