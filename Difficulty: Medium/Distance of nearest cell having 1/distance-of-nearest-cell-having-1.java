class pair{
    int r;
    int c;
    int d;
    pair(int r, int c,int d){
        this.r = r;
        this.c = c;
        this.d = d;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][] visited = new int[n][m];
    int[][] ans = new int[n][m];
     Queue<pair> q = new LinkedList<>();
     for(int i = 0 ; i< n ; i++){
         for(int j = 0;j<m;j++){
             if(grid[i][j] == 1){
                 q.add(new pair(i,j,0));
                 visited[i][j] = 1;

             }
         }
     }
     //pair s = q.poll();
     int[] drow = {-1,0,1,0};
     int[] dcol = {0,-1,0,1};
    while(!q.isEmpty()){
        pair s = q.poll();
        //q.remove();
        int r = s.r;
        int c = s.c;
        int d = s.d;
        ans[r][c] = d;
        for(int i=0;i<4;i++){
            
            int nr = r + drow[i];
            int nc = c + dcol[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==0){
                visited[nr][nc]=1;
                q.add(new pair(nr,nc,d+1));
            }
        }
    }
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

          for (int i = 0; i < n; i++) {

              ArrayList<Integer> row = new ArrayList<>();

              for (int j = 0; j < m; j++) {
                  row.add(ans[i][j]);
              }

              result.add(row);
          }

          return result;
    }
}