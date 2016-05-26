public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // Stack<String> stack = new Stack<>();
        // String[] word = s.trim().split(" ");
        // int len = word.length;
        // for (String ss : word) {
        //     if (ss.length() == 0) {
        //         len--;
        //     } else {
        //         stack.push(ss);
        //     }
        // }
        // String a = new String();
        // for (int i = 0; i < len; i++) {
        //     a = a + stack.pop() + " ";
        // }
        // return a.trim();
        String[] word = s.trim().split(" ");
        int i = 0, j = word.length - 1;
        while (i < j) {
            String temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        String a = new String();
        for (int ss : word) {
            a += ss + " ";
        }
        return a.trim();
    }
}