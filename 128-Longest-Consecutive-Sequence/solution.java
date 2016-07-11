public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int lower = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int upper = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                int sum = lower + upper + 1;
                map.put(n, sum);
                res = Math.max(res, sum);
                
                map.put(n - lower, sum);
                map.put(n + upper, sum);
            } else {
                continue;
            }
        }
        return res;
    }
}