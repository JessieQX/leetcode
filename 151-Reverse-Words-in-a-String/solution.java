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
        // String[] word = s.trim().split(" ");
        // int i = 0, j = word.length - 1;
        // while (i < j) {
        //     if (word[i].length() == 0) {
        //         i++;
        //     }
        //     if (word[j].length() == 0) {
        //         j--;
        //     }
        //     String temp = word[i];
        //     word[i] = word[j];
        //     word[j] = temp;
        //     i++;
        //     j--;
        // }
        // String a = new String();
        // for (String ss : word) {
        //     if (ss.length() != 0) {
        //         a += ss + " ";
        //     }
        // }
        // return a.trim();
        String[] word = s.trim().split("\\s+");
        String res = "";
        for (int i = word.length - 1; i > 0; i--) {
            res += word[i] + " ";
        }
        return res + word[0];
    }
}