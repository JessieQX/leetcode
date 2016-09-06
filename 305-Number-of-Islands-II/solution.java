public class Solution {
    private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        int count = 0;
        for (int[] p : positions) {
            int root = p[0] * n + p[1];
            roots[root] = root;
            count++;
            
            for (int[] d : dir) {
                int x = p[0] + d[0];
                int y = p[1] + d[1];
                int point = x * n + y;
                if (x < 0 || x >= m || y < 0 || y >= n || roots[point] == -1) continue;
                int rootPoint = find(roots, point);
                if (rootPoint != root) {
                    roots[root] = rootPoint;
                    root = rootPoint;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    private int find(int[] roots, int root) {
        if (roots[root] == root) {
            return root;
        }
        return find(roots, roots[root]);
    } 
}