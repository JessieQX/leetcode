public class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String[] word = s.split(" ");
        for (String ss : word) {
            stack.push(ss);
        }
        String a = new String();
        for (int i = 0; i < word.size(); i++) {
            a = a + stack.pop() + " ";
        }
        return a;
    }
}