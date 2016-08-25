public class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        int currPath = 0;
        int maxPath = 0;
        String[] paths = input.split("\n");
        for (String path : paths) {
            while (!stack.isEmpty() && numOfSpace(stack.peek()) >= numOfSpace(path)) {
                currPath -= path.length();
                stack.pop();
            }
            currPath += (path.length() - numOfSpace(path) + 1);
            stack.push(path);
            if (isEnd(path)) {
                maxPath = Math.max(maxPath, path);
            }
        }
        return maxPath;
    }
    private int numOfSpace(String path) {
        return path.length() - path.trim().length();
    }
    private boolean isEnd(String path) {
        if (path.contains("\\.")) {
            return true;
        }
        return false;
    }
}