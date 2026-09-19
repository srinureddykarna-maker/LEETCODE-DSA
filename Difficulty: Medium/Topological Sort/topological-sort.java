class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

                for (int i = 0; i < V; i++) {
                    adj.add(new ArrayList<>());
                }

                // Build graph + calculate indegree
                //int[] indegree = new int[V];

                for (int[] edge : edges) {
                    int u = edge[0];
                    int v = edge[1];

                    adj.get(u).add(v);
                 //   indegree[v]++;
                }
                //int v = edges.length;
                int[] visited = new int[V];
                
        Stack<Integer> q = new Stack<>();
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,adj,visited,q);
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();

                while (!q.isEmpty()) {
                    answer.add(q.pop());
                }

                return answer;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>>adj,int[] visited,Stack<Integer> q){
        visited[node]=1;
        for(int it : adj.get(node)){
            if(visited[it]==0){
                dfs(it,adj,visited,q);
            }
        }
        q.push(node);
    }
}