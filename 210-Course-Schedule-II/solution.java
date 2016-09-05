public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // List<List<Integer>> adjs = new ArrayList<>(numCourses);
        // int[] indegree = new int[numCourses];
        // initializeGraph(adjs, indegree, prerequisites);
        // return solveByBFS(indegree, adjs);
        int[][] courses = new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];
		int[] order = new int[indegree.length];
		for (int[] prerequisite : prerequisites) {
			int pre = prerequisite[1];
			int post = prerequisite[0];
			if (courses[pre][post] == 0) {
				indegree[post]++;
			}
			courses[pre][post] = 1;
		}

		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int preCourse = queue.poll();
			order[count++] = preCourse;
			for (int i = 0; i < numCourses; i++) {
				if (courses[preCourse][i] != 0) {
					if (--indegree[i] == 0) {
						queue.offer(i);
					}
				}
			}
		}
		//return count == numCourses;
		return indegree.length == count ? order : new int[0];
    }
    // private void initializeGraph(List<List<Integer>> adjs, int[] indegree, int[][] prerequisites) {
    //     int n = indegree.length;
    //     while (n-- > 0) {
    //         adjs.add(new ArrayList<>());
    //     }
    //     for (int[] edge : prerequisites) {
    //         indegree[edge[0]]++;
    //         adjs.get(edge[1]).add(edge[0]);
    //     }
    // }
    // private int[] solveByBFS(int[] indegree, List<List<Integer>> adjs) {
    //     int[] order = new int[indegree.length];
    //     Queue<Integer> queue = new LinkedList<>();
    //     for (int i = 0; i < indegree.length; i++) {
    //         if (indegree[i] == 0) {
    //             queue.offer(i);
    //         }
    //     }
    //     int index = 0;
    //     while (!queue.isEmpty()) {
    //         int pre = queue.poll();
    //         order[index++] = pre;
    //         for (int post : adjs.get(pre)) {
    //             if (--indegree[post] == 0) {
    //                 queue.offer(post);
    //             }
    //         }
    //     }
    //     return indegree.length == index ? order : new int[0];
    // }
}