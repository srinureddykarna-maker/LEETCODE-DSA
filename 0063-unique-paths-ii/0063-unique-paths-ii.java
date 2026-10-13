class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                }
                else if (i == 0 && j == 0) {
                    dp[j] = 1;
                }
                else {
                    int up = dp[j];
                    int left = 0;

                    if (j > 0) {
                        left = dp[j - 1];
                    }

                    dp[j] = up + left;
                }
            }
        }

        return dp[n - 1];
    }
}