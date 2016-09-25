public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }
        
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * factorial[n - i];
        }
        
        return sb.toString();
    }
}