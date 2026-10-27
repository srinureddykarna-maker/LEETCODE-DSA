class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int u = matrix[i][j] + dp[i - 1][j];

                int sl = Integer.MAX_VALUE;
                if (j > 0) {
                    sl = matrix[i][j] + dp[i - 1][j - 1];
                }

                int sr = Integer.MAX_VALUE;
                if (j < m - 1) {
                    sr = matrix[i][j] + dp[i - 1][j + 1];
                }

                dp[i][j] = Math.min(u, Math.min(sl, sr));
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }
}