class Solution {
    int[] parent ;
    int[] rank;
    int find(int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] =i;
            rank[i] = 0;

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] ==1){
                    int rooti = find(i);
                    int rootj = find(j);
                    if(rooti != rootj){
                        if(rank[rooti]<rank[j]){
                            parent[rooti] = rootj;
                        }else if(rank[rooti]>rank[rootj]){
                            parent[rootj] = rooti;
                        }else{
                            parent[rootj] = rooti;
                            rank[rooti]++;
                        }
                    }
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(parent[i] == i){
                cnt++;
            }
        }
        return cnt;
    }
}