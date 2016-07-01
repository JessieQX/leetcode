public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int count1 = 0, count2 = 0, m1 = 0, m2 = 0;
        for (int n : nums) {
            if (m1 == n) {
                count1++;
            } else if (m2 == n) {
                count2++;
            } else if (count1 == 0) {
                m1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                m2 = n;
                count2 = 1;
            } else {
                count1 = count1 - 1;
                count2 = count2 - 1;
            }
        }
        int count1 = 0, count2 = 0;
        for (int n : nums) {
            if (m1 == n) {
                count1++;
            } else if (m2 == n) {
                count2++;
            }
        }
        if (count1 >= nums.length / 3) {
            list.add(m1);
        }
        if (count2 >= nums.length / 3) {
            list.add(m2);
        }
        return list;
    }
}