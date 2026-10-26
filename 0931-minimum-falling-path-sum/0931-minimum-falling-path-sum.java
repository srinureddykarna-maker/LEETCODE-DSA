import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, solve(0, j, matrix, dp));
        }

        return ans;
    }

    public int solve(int row, int col, int[][] matrix, int[][] dp) {
        int n = matrix.length;

        if (col < 0 || col >= n) {
            return Integer.MAX_VALUE / 2;
        }

        if (row == n - 1) {
            return matrix[row][col];
        }

        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        int down = solve(row + 1, col, matrix, dp);
        int left = solve(row + 1, col - 1, matrix, dp);
        int right = solve(row + 1, col + 1, matrix, dp);

        dp[row][col] = matrix[row][col]
                + Math.min(down, Math.min(left, right));

        return dp[row][col];
    }
}