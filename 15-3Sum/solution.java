public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                //if nums[i] == nums[i - 1], there will be duplicates, so move forward
                int sum = 0 - nums[i];//assume nums[i], make nums[i] = sum - nums[m] - nums[n]
                int m = i + 1;
                int n = nums.length - 1;
                while (m < n) {
                    if (nums[m] + nums[n] == sum) {
                        list.add(Arrays.asList(nums[i], nums[m], nums[n]));
                        //if there is duplicates in next nums, m should move forward
                        while (m < n && nums[m] == nums[m + 1]) m++;
                        while (m < n && nums[n] == nums[n - 1]) n--;
                        m++; n--;
                    } else if (nums[m] + nums[n] < sum) {
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }
        return list;
    }
}