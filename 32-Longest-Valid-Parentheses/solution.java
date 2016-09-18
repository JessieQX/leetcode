public class Solution {
    public int longestValidParentheses(String s) {
        //if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int index = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    index = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i - index);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
        // Stack<Integer> stack = new Stack<Integer>();
        // int max=0;
        // int left = -1;
        // for(int j=0;j<s.length();j++){
        //     if(s.charAt(j)=='(') stack.push(j);            
        //     else {
        //         if (stack.isEmpty()) left=j;
        //         else{
        //             stack.pop();
        //             if(stack.isEmpty()) max=Math.max(max,j-left);
        //             else max=Math.max(max,j-stack.peek());
        //         }
        //     }
        // }
        // return max;
    }
}