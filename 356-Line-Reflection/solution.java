public class Solution {
    public boolean isReflected(int[][] points) {
        // if (points.length <= 1 || points[0].length == 0) return true;
        // int res = points[0][1];
        // for (int i = 1; i < points.length; i++) {
        //     if (points[i][1] != res) return false;
        // }
        // return true;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            set.add(point[0] + "a" + point[1]);
        }
        int sum = max + min;
        for (int[] point : points) {
            String str = sum - point[0] + "a" + point[1];
            if (!set.contains(str)) {
                return false;
            }
        }
        return true;
    }
}