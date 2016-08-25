public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (lower > nums[0] || upper < nums[nums.length]) {
            return res;
        }
        if (lower + 1 < nums[0]) {
            if ((lower + 1) == (nums[0] - 1)) {
                res.add(lower + 1 + "");
            } else {
                res.add((lower + 1) + "->" + (nums[0] - 1));
            }
        } else if ((upper - 1) > nums[nums.length]) {
            if ((upper - 1) == (nums[nums.length] + 1)) {
                res.add((upper - 1) + "");
            } else {
                res.add((upper - 1) + "->" + (nums[nums.length] + 1));
            }
        } else {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] == 1) {
                    continue;
                } else if (nums[i] - nums[i - 1] == 2) {
                    res.add((nums[i] - 1) + "");
                } else {
                    res.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
                }
            }
        }
        return res;
    }
}