class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Solution {

    public boolean isCycle(int V, int[][] edges) {

        // 1. Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // 2. Add edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // 3. Visited array
        boolean[] visited = new boolean[V];

        // 4. Check every component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(
        int node,
        int parent,
        ArrayList<ArrayList<Integer>> adj,
        boolean[] visited
    ) {

        visited[node] = true;

        for (int neighbour : adj.get(node)) {

            // If neighbour is not visited
            if (!visited[neighbour]) {

                if (dfs(neighbour, node, adj, visited)) {
                    return true;
                }

            }
            // Neighbour already visited and it is NOT parent
            else if (neighbour != parent) {
                return true;
            }
        }

        return false;
    }
}