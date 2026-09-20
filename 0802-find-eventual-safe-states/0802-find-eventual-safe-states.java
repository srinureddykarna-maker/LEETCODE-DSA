class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;

        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] outdegree = new int[V];

        for (int u = 0; u < V; u++) {

            outdegree[u] = graph[u].length;

            for (int v : graph[u]) {
                adj.get(v).add(u);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if (outdegree[i] == 0) {
                q.add(i);
            }
        }

        boolean[] safe = new boolean[V];

        while (!q.isEmpty()) {

            int node = q.poll();

            safe[node] = true;

            for (int prev : adj.get(node)) {

                outdegree[prev]--;

                if (outdegree[prev] == 0) {
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