public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int i = 0, j = 0, min = 0, max = m, mid = (m + n + 1) / 2;
        while (min <= max) {
            i = (min + max) / 2;
            j = mid - i;
            if (i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                max = i - 1;
            } else if (j > 0 && i < m && nums[j - 1] > nums2[i]) {
                min = i + 1;
            } else {
                break;
            }
        }
        int leftMax = 0, rightMin = 0;
        if (i == 0) leftMax = nums2[j - 1];
        else if (j == 0) leftMax = nums1[i - 1];
        else leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
        if ((m + n) % 2 == 1) return leftMax;
        if (i == m) rightMin = nums2[j];
        else if (j == n) rightMin = nums1[i];
        else rightMin = Math.min(nums1[i], nums2[j]);
        return (leftMax + rightMin) / 2;
    }
}