public class Solution {
    public static int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] visitedTimes = new int[m][n];
        int numOfOne = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numOfOne++;
                    int dist = 0;
                    boolean[][] visited = new boolean[m][n];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] data = queue.poll();
                            int x = data[0];
                            int y = data[1];
                            distance[x][y] += dist;
                            visitedTimes[x][y]++;
                            if ((x - 1) >= 0 && grid[x - 1][y] == 0 && !visited[x - 1][y]) {
                                queue.add(new int[]{x - 1, y});
                                visited[x - 1][y] = true;
                            }
                            if ((x + 1) < m && grid[x + 1][y] == 0 && !visited[x + 1][y]) {
                                queue.add(new int[]{x + 1, y});
                                visited[x + 1][y] = true;
                            }
                            if ((y - 1) >= 0 && grid[x][y - 1] == 0 && !visited[x][y - 1]) {
                                queue.add(new int[]{x, y - 1});
                                visited[x][y - 1] = true;
                            }
                            if ((y + 1) < n && grid[x][y + 1] == 0 && !visited[x][y + 1]) {
                                queue.add(new int[]{x, y + 1});
                                visited[x][y + 1] = true;
                            }
                        }
                        dist++;
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && visitedTimes[i][j] == numOfOne && distance[i][j] < res) {
                    res = distance[i][j];
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}