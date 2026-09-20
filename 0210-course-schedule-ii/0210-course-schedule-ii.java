class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] edge : prerequisites) {

            int course = edge[0];
            int prerequisite = edge[1];

            // prerequisite → course
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        // Courses having no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();

            ans.add(node);

            for (int next : adj.get(node)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        // Cycle exists
        if (ans.size() != numCourses) {
            return new int[0];
        }

        // Convert ArrayList → int[]
        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}