public class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String[] word = s.split(" ");
        for (String ss : word) {
            stack.push(ss);
        }
        StringBuilder sb = new StringBuider();
        for (int i = 0; i < word.size(); i++) {
            sb.append(stack.pop()).append(" ");
        }
        return sb;
    }
}