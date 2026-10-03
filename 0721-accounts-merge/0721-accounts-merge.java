class Solution {
    int[] parent;
    int[] rank;
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int u,int v){
        int rootu = find(u);
        int rootv = find(v);
        if(rootu == rootv){
            return;
        }
        if(rank[rootu]>rank[rootv]){
            parent[rootv] = rootu;
        }else if(rank[rootv]>rank[rootu]){
            parent[rootu] = rootv; 
        }else{
            parent[rootv] = rootu;
            rank[rootu]++;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                if(!map.containsKey(email)){
                    map.put(email,i);
                }else{
                    int previousAccount = map.get(email);
                    union(i,previousAccount);
                }
            }
        }
        HashMap<Integer,List<String>> merged = new HashMap<>();
        for(String email:map.keySet()){
            int account = map.get(email);
            int root = find(account);
            if(!merged.containsKey(root)){
                merged.put(root,new ArrayList<>());
            }
            merged.get(root).add(email);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int root: merged.keySet()){
            List<String> emails = merged.get(root);
            Collections.sort(emails);
            List<String> current  = new ArrayList<>();
            current.add(accounts.get(root).get(0));
            for(String email:emails){
                current.add(email);
            }
            ans.add(current);
        }
return ans;
        
    }
}