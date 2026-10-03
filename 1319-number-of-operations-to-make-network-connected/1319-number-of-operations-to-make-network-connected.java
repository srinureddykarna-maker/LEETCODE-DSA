class Solution {
    int[] parent;
    int[] rank;
    int find(int x){
        if(parent[x]==x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public int makeConnected(int n, int[][] connections) {
          if (connections.length < n - 1) {
            return -1;
        }

        int v = connections.length;
        parent = new int[n];
        rank   = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;

        }
        int extraedge=0;
        for(int i=0;i<v;i++){
            int rooti = find(connections[i][0]);
            int rootj = find(connections[i][1]);
            if(rooti == rootj){
                extraedge++;
            }else{
                if(rank[rooti]<rank[rooti]){
                    parent[rooti]= rootj;

                }else if(rank[rooti]>rank[rootj]){
                    parent[rootj] = rooti;
                }else{
                    parent[rootj] = rooti;
                    rank[rooti]++;
                }

                }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) cnt++;
        }
        if(cnt-1 <= extraedge){
            return cnt-1;
        }
         return -1;
    }
}