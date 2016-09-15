public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new Point(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Point p = pq.poll();
            if (p.x == n - 1) continue;
            pq.offer(new Point(p.x + 1, p.y, matrix[p.x + 1][p.y]));
        }
        return pq.poll().val;
    }
    class Point implements Comparator<Point> {
        int x, y, val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        public int compareTo(Point p) {
            return this.val - p.val;
        }
    }
}