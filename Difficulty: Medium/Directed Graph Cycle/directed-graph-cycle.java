class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
       
                ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
                for(int i=0;i<V;i++){
                    adj.add(new ArrayList<>());
                }
                int[] indegree = new int[V];

                      for (int[] edge : edges) {
                          int u = edge[0];
                          int v = edge[1];

                          adj.get(u).add(v);
                          indegree[v]++;
                      }
                      Queue<Integer> q = new LinkedList<>();
                      for(int i=0;i<V;i++){
                          if(indegree[i]==0){
                              q.add(i);

                          }
                      }
                //for(int i=0;i<adj.length;i++){
                ArrayList<Integer> ans = new ArrayList<>();
                while(!q.isEmpty()){
                    int node = q.poll();
                    ans.add(node);
                    for(int it:adj.get(node)){
                        indegree[it]--;
                        if(indegree[it]==0){
                            q.add(it);
                        }
                    }
                //return ans;

                }
                if(V!=ans.size()){
                    return true;
                }else return false;
            }
        }
    
