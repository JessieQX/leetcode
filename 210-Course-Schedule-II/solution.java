public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses];
        initializeGraph(adjs, indegree, prerequisites);
        return solveByBFS(indegree, adjs);
    }
    private void initializeGraph(List<List<Integer>> adjs, int[] indegree, int[][] prerequisites) {
        int n = indegree.length;
        while (n-- > 0) {
            adjs.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }
    private int[] solveByBFS(int[] indegree, List<List<Integer>> adjs) {
        int[] order = new int[indegree.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            order[index++] = pre;
            for (int post : adjs.get(pre)) {
                if (--indegree[post] == 0) {
                    queue.offer(post);
                }
            }
        }
        return indegree.length == index ? order : new int[0];
    }
}