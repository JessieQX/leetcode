public class Solution {
    Map<Character, String> map = new HashMap<>();

    public boolean wordPatternMatch(String pattern, String str) {
        // Map<Character, String> map = new HashMap<>();
        // Set<String> set = new HashSet<>();
        // //return isMatch(pattern, 0, str, 0, map, set);
        // return isMatch(str, 0, pattern, 0, map, set);
         if (pattern.length() == 0) {
        return str.length() == 0;
       }
       if (map.containsKey(pattern.charAt(0))) {
        String val = map.get(pattern.charAt(0));
        if (str.length() < val || !str.startWith(val)) {
          return false;
        } else {
          if (wordPattern(pattern.substring(1), str.substring(val.length()))) {
            return true;
          }
        }
       } else {
        for (int i = 1; i < str.length(); i++) {
          String value = str.substring(0,i);
          if (map.containValue(value)) {
            continue;
          }
          map.put(pattern.charAt(0), value);
          if (wordPattern(pattern.substring(1), str.substring(value.length()))) {
            return true;
          }
          map.remove(pattern.charAt(0));
        }
       }
       return false;

    }
    // private boolean isMatch(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set) {
    //     if (i == pattern.length() && j == str.length()) return true;
    //     if (i == pattern.length() || j == str.length()) return false;
        
    //     //get the current pattern character
    //     char c = pattern.charAt(i);
        
    //     //if the current pattern character exists
    //     if (map.containsKey(c)) {
    //         String s = map.get(c);
    //         //then we can check if there is a match str[j, j + s.length()]
    //         if (!str.startsWith(s, j)) {
    //             return false;
    //         }
    //         //if there is a match, then we continue to match the rest
    //         return isMatch(pattern, i + 1, str, j + s.length(), map, set);
    //     }
        
    //     //if pattern doesn't exist in map
    //     for (int k = j; k < str.length(); j++) {
    //         String sub = str.substring(j, k + 1);
    //         if (set.contains(sub)) continue;
    //         map.put(c, sub);
    //         set.add(sub);
    //         //continue to match rest
    //         if (isMatch(pattern, i + 1, str, k + 1, map, set)) {
    //             return true;
    //         }
    //         //backtracking
    //         map.remove(c);
    //         set.remove(sub);
    //     }
    //     return false;
    // }
    // boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
    // // base case
    // if (i == str.length() && j == pat.length()) return true;
    // if (i == str.length() || j == pat.length()) return false;
    
    // // get current pattern character
    // char c = pat.charAt(j);
    
    // // if the pattern character exists
    // if (map.containsKey(c)) {
    //   String s = map.get(c);
      
    //   // then check if we can use it to match str[i...i+s.length()]
    //   if (!str.startsWith(s, i)) {
    //     return false;
    //   }
      
    //   // if it can match, great, continue to match the rest
    //   return isMatch(str, i + s.length(), pat, j + 1, map, set);
    // }
    
    // // pattern character does not exist in the map
    // for (int k = i; k < str.length(); k++) {
    //   String p = str.substring(i, k + 1);

    //   if (set.contains(p)) {
    //     continue;
    //   }

    //   // create or update it
    //   map.put(c, p);
    //   set.add(p);
      
    //   // continue to match the rest
    //   if (isMatch(str, k + 1, pat, j + 1, map, set)) {
    //     return true;
    //   }

    //   // backtracking
    //   map.remove(c);
    //   set.remove(p);
    // }
    
    // we've tried our best but still no luck
//     return false;
//   }
}