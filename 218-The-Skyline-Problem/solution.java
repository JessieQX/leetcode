public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        queue.add(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                queue.add(-h[1]);
            } else {
                queue.remove(h[1]);
            }
            int curr = queue.peek();
            if (prev != curr) {
                res.add(new int[]{h[0], curr});
                prev = curr;
            }
        }
        return res;
    }
}