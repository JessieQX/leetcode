public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        String[] word = s.trim().split(" ");
        int len = word.length;
        for (String ss : word) {
            //System.out.println("ss= " + ss);
            ss = ss.trim();
            //System.out.println("new ss= " + ss);
            if (ss.length() == 0) {
                len--;
            } else {
                stack.push(ss);
            }
        }
        String a = new String();
        for (int i = 0; i < len; i++) {
            a = a + stack.pop() + " ";
        }
        return a.trim();
    }
}