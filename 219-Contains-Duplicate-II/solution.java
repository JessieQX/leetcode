public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)  set.remove(nums[i - k - 1]);//说明nums[i]在k的范围内没有相同的数，所以去掉nums[i]。
            if (!set.add(nums[i])) return true;
        }
        return false;
        
//         Map<Integer, Integer> map = new HashMap<>();
// 		for (int i = 0; i < nums.length; i++) {
// 			if (!map.containsKey(nums[i])) {
// 				map.put(nums[i], i);
// 			} else {
// 				if (Math.abs(map.get(nums[i]) - i) <= k) {
// 					return true;
// 				}
// 			}
// 		}
// 		return false;
    }
}