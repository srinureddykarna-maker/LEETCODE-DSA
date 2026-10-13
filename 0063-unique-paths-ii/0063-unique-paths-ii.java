class Solution {
    

    int solve(int i, int j,int[][] obstacleGrid,int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        } 

        int up = solve(i - 1, j,obstacleGrid,dp);
        int left = solve(i, j - 1,obstacleGrid,dp);
        dp[i][j] = up+left;

        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }

        return solve(m - 1, n - 1,obstacleGrid,dp);
    }
}