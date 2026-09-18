class Solution {
    private boolean dfs(int[][] graph,int j,int color,int[]  clr){
        int n = graph.length;
        //Queue<Integer> q = new LinkedList<>();
        //q.add(j);
        clr[j] = color;
       // while(!q.isEmpty()){
            //int node = q.peek();
          //  q.remove();
             for (int i = 0; i < graph[j].length; i++) {

                int neighbour = graph[j][i];
                if(clr[neighbour]==-1){
                    if(dfs(graph,neighbour,1-color,clr)==false){
                        return false;
                    }
                    }
                    else if(clr[neighbour]==clr[j]){
                        return false;
                    }
                

                //if (clr[neighbor] == -1) {
                   // clr[neighbor] = 1 - clr[node];
                   // q.add(neighbor);
                //}
               // else if (clr[neighbor] == clr[node]) {
               //     return false;
               // }
            }
        //}
            return true;
        
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        //Queue<Integer> q = new LinkedList<>();
        int[] clr = new int [n];
        for(int i=0;i<n;i++) clr[i]=-1;
        for(int i=0;i<n;i++){
            if(clr[i]==-1){
                if(dfs(graph,i,0,clr)==false){
                    return false;
                }
            }
        }
        return true;

    }
}