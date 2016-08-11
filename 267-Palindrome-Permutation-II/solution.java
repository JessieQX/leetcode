public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        char[] c = s.toCharArray();
        char[] nums = new char[c.length / 2];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < c.length; i++) {
            if (!set.add(c[i])) {
                nums[i] = c[i];
                set.remove(c[i]);
            }
        }
        if (set.size() <= 1) {
            res = permuteUnique(nums);
        }
        return res;
    }
    private List<String> permuteUnique(char[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        String s = new String();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permuteHelper(res, s, nums, visited);
        return res;
    }
    private void permuteHelper(List<String> res, String s, char[] nums, boolean[] visited) {
        if (nums.length == s.length()) {
            res.add(new String(s));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            //list.add(nums[i]);
            s += nums[i];
            permuteHelper(res, s, nums, visited);
            visited[i] = false;
            s = s.substring(0, s.length() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}