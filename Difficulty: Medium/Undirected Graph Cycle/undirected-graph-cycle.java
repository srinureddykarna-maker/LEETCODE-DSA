class pair {
    int node;
    int parent;

    pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        // 1. Create adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            boolean[] visited = new boolean[V];
            
            for(int i=0;i<V;i++){
                if(!visited[i]){
                    Queue<pair> q = new LinkedList<>();
                    q.offer(new pair(i,-1));
                    visited[i]=true;
                    while(!q.isEmpty()){
                        pair current = q.poll();
                        int node = current.node;
                        int parent = current.parent;
                        for(int neighbour : adj.get(node)){
                            if(!visited[neighbour]){
                                visited[neighbour] =true;
                                q.offer(new pair(neighbour,node));
                                
                            }else if( neighbour != parent){
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
    }
}