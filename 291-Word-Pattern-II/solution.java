public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return isMatch(pattern, 0, str, 0, map, set);
    }
    private boolean isMatch(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set) {
        if (i == pattern.length() && j == str.length()) return true;
        if (i == pattern.length() || j == str.length()) return false;
        
        //get the current pattern character
        char c = pattern.charAt(i);
        
        //if the current pattern character exists
        if (map.containsKey(c)) {
            String s = map.get(c);
            //then we can check if there is a match str[j, j + s.length()]
            if (!str.startsWith(s, j)) {
                return false;
            }
            //if there is a match, then we continue to match the rest
            return isMatch(pattern, i + 1, str, j + s.length(), map, set);
        }
        
        //if pattern doesn't exist in map
        for (int k = j; k < str.length(); j++) {
            String sub = str.substring(j, k + 1);
            if (set.contains(sub)) continue;
            map.put(c, sub);
            set.add(sub);
            //continue to match rest
            if (isMatch(pattern, i + 1, str, k + 1, map, set)) {
                return true;
            }
            //backtracking
            map.remove(c);
            set.remove(sub);
        }
        return false;
    }
}