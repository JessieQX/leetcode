public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return res;
        
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.offer(new Point(nums1[i], nums2[j], nums1[i] + nums2[j]));
            }
        }
        for (int i = 0; i < k; i++) {
            Point p = pq.poll();
            int x = p.x;
            int y = p.y;
            res.add(new int[]{x, y});
        }
        return res;
    }
    class Point implements Comparable<Point> {
        int x, y, val;
        public Point (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        public int compareTo(Point p) {
            return this.val - p.val;
        }
    }
}