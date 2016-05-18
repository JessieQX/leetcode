public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i + 1] == nums[i]) {
                count++;
            } else {
                map.put(nums[i], count);
            }
            
        }
        if (!map.containsKey(nums[nums.length - 1])) {
            map.put(nums[nums.length - 1], 1);
        }
        int[] a = new int[map.size()];
        for (int i = 0; i < map.size(); i++) {
            for (int key : map.keySet()) {
                a[i] = map.get(key);
            }
        }
        Arrays.sort(a);
        for (int i = 0; i < k; i++) {
            list.add(a[i]);
        }
        return list;
    }
}