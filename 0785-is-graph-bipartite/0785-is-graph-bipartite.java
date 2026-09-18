class Solution {
    private boolean check(int[][] graph,int j,int[]  clr){
        int n = graph.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(j);
        clr[j] = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
             for (int i = 0; i < graph[node].length; i++) {

                int neighbor = graph[node][i];

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
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        //Queue<Integer> q = new LinkedList<>();
        int[] clr = new int [n];
        for(int i=0;i<n;i++) clr[i]=-1;
        for(int i=0;i<n;i++){
            if(clr[i]==-1){
                if(check(graph,i,clr)==false){
                    return false;
                }
            }
        }
        return true;

    }
}