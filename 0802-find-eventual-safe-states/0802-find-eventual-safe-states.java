class Solution {
    boolean dfs(int node ,int[][] graph,int[] vis,int[] pathvis,int[] check){
        int v = graph.length;
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        for(int it =0;it<graph[node].length;it++){
            int neighbour = graph[node][it];
            if(vis[neighbour]==0){
                if(dfs(neighbour,graph,vis,pathvis,check)==true){
                    return true;
                }
            }
            else if(pathvis[neighbour]==1){
                return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;

    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        int[] vis = new int[v];
        int[] check = new int[v];
        int[] pathvis = new int[v];
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,pathvis,check);
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<v;i++){
           if(check[i]==1){
            answer.add(i);
           }
        }
         return answer;
    }
}