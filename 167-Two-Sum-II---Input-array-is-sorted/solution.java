public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        if (numbers[0] > target) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i);
            } else {
                res[0] = map.get(target - numbers[i]) + 1;
                res[1] = i + 1;
            }
        }
        return res;
    }
}