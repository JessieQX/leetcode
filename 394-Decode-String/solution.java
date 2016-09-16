public class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> wordStack = new Stack<>();
        int i = 0;
        String res = "";
        while (i < s.length()) {
            //char c = s.charAt(i);
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                countStack.push(count);
            }
            else if (s.charAt(i) == '[') {
                wordStack.push(res);
                res = "";
                i++;
            }
            else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(wordStack.pop());
                int num = countStack.pop();
                for (int j = 0; j < num; j++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            }
            else {
                res += s.charAt(i);
            }
        }
        return res;
    }
}