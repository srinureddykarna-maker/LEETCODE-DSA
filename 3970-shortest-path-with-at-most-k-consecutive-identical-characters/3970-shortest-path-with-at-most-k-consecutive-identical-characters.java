class state {
    int node;
    int count;
    long cost;

    state(int node, int count, long cost) {
        this.node = node;
        this.count = count;
        this.cost = cost;
    }
}
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];

         for (int i = 0; i < n; i++) {
         adj[i] = new ArrayList<>();
            }

          for (int[] edge : edges) {
          int u = edge[0];
          int v = edge[1];
          int w = edge[2];

           adj[u].add(new int[]{v, w});
            }
            long[][] dist = new long[n][k+1];
            for(int i=0;i<n;i++){
                Arrays.fill(dist[i],Long.MAX_VALUE);
            }
            PriorityQueue<state> pq = new PriorityQueue<>(
        (a, b) -> Long.compare(a.cost, b.cost) );
        dist[0][1] = 0;
        pq.offer(new state(0, 1, 0));
        while(!pq.isEmpty()){
            state cur = pq.poll();
            int u = cur.node;
            int count = cur.count;
            long cost = cur.cost;
            if(cost != dist[u][count]){
                continue;
            }
            if (u == n - 1) {
                 return (int) cost;
              }
            for(int[] next : adj[u]){
                int v = next[0];
                int weight = next[1];
                int newcount;
                if(labels.charAt(u) == labels.charAt(v)){
                    newcount = count +1;
                }else{
                    newcount = 1;
                }
                if(newcount >k){
                    continue;
                }
                long newcost = cost + weight;
                if(newcost < dist[v][newcount]){
                    dist[v][newcount] = newcost;
                    pq.offer(new state(v,newcount,newcost));
                }
            }
        }
        return -1;
        
    }
}