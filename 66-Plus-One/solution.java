public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;// it is important to return digits.
            } else {
                digits[i] = 0;
            }
        }
        
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            newDigits[i] = 0;
        }
        
        return newDigits;
    }
}