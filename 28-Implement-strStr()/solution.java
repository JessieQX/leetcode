public class Solution {
    public int strStr(String haystack, String needle) {
        // int index = haystack.indexOf(needle);
        // return index;
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0 || needle.equals(haystack)) {
            return 0;
        }
        int len1 = needle.length();
        int len2 = haystack.length();
        int start = 0;
        while (start <= (len2 - len1)) {
            int i = start;
            for (int j = 0; j < len1; j++) {
                Character c1 = needle.charAt(j);
                Character c2 = haystack.charAt(i);
                if (c1 != c2) {
                    start++;
                    break;
                } else {
                    if (j == len1 - 1) {
                        return start; 
                    } else {
                        i++;
                    }
                }
            }
        }
        return -1;
    }
}