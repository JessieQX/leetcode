public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            if (a >= 0) {
                res[index--] = calculation(nums[i], a, b, c) >= calculation(nums[j], a, b, c) ? calculation(nums[i++], a, b, c) : calculation(nums[j--], a, b, c);
            } else {
                res[index++] = calculation(nums[i], a, b, c) <= calculation(nums[j], a, b, c) ? calculation(nums[i++], a, b, c) : calculation(nums[j--], a, b, c);
            }
        }
        return res;
    }
    private int calculation(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}