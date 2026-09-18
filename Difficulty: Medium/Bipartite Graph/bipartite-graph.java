class Solution {

    private boolean checkdfs(ArrayList<ArrayList<Integer>> adj, int start, int color,int[] clr) {

        //Queue<Integer> q = new LinkedList<>();

       // q.add(start);
        clr[start] = color;

       // while (!q.isEmpty()) {

           // int node = q.peek();
            //q.remove();

            for (int i = 0; i < adj.get(start).size(); i++) {

                int neighbour = adj.get(start).get(i);

                if (clr[neighbour] == -1) {
                   if(checkdfs(adj,neighbour,1-color,clr)==false){
                       return false;
                   }
                }
                else if (clr[neighbour] == clr[start]) {
                    return false;
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

                if (checkdfs(adj, i,0, clr) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}