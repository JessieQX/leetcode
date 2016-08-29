public class Solution {
    public boolean isReflected(int[][] points) {
        int res = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][1] != res) return false;
        }
        return true;
    }
}