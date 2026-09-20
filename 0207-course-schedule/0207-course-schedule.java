class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = numCourses;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];

              for (int[] edge : prerequisites) {
                  int u = edge[0];
                  int v = edge[1];

                  adj.get(v).add(u);
                  indegree[u]++;
              }
              Queue<Integer> q = new LinkedList<>();
              for(int i=0;i<V;i++){
                  if(indegree[i]==0){
                      q.add(i);
                      
                  }
              }
              int count=0;
              while(!q.isEmpty()){
                int node = q.poll();
                count++;
                for(int it:adj.get(node)){
                    indegree[it]--;
                    if(indegree[it]==0){
                        q.add(it);
                    }
                }
              }
        if(V!=count){
            return false;
        }else return true;
    }
}