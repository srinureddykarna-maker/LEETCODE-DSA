class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;

        // Reverse graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        // Build reverse graph
        for (int u = 0; u < V; u++) {

            for (int v : graph[u]) {

                adj.get(v).add(u);
                indegree[u]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        // Terminal nodes
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        boolean[] safe = new boolean[V];

        while (!q.isEmpty()) {

            int node = q.poll();

            safe[node] = true;

            for (int prev : adj.get(node)) {

                indegree[prev]--;

                if (indegree[prev] == 0) {
                    q.add(prev);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}
