class Solution {

    private boolean check(ArrayList<ArrayList<Integer>> adj, int start, int[] clr) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        clr[start] = 0;

        while (!q.isEmpty()) {

            int node = q.peek();
            q.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {

                int neighbor = adj.get(node).get(i);

                if (clr[neighbor] == -1) {
                    clr[neighbor] = 1 - clr[node];
                    q.add(neighbor);
                }
                else if (clr[neighbor] == clr[node]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert edge list to adjacency list
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] clr = new int[V];

        for (int i = 0; i < V; i++) {
            clr[i] = -1;
        }

        // Handle disconnected components
        for (int i = 0; i < V; i++) {

            if (clr[i] == -1) {

                if (check(adj, i, clr) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}