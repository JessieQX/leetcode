public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int i = 1;
        int j = 2;
        int major = nums[0];
        int count = 1;
        while (i < n) {
            if (major == nums[j++]) {
                count++;
            }
            if (j >= n && count < n / 3) {
                i = i + 1;
                j = i + 1;
                count = 1;
            }
            if (j < n && count >= n / 3) {
                list.add(major);
                i = i + 1;
                j = i + 1;
                count = 1;
            }
        }
        return list;
    }
}