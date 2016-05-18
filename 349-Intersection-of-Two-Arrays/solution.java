public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //int[] intersection = new int[nums1.length + nums2.length];
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        // int[] intersection = new int[res.size()];
        // for (int i = 0; i < intersection.length; i++) {
        //     intersection[i] = res.toArray
        // }
        return res.toArray();
    }
}