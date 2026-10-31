import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return (solve(dp, grid, 0, 0, 0, n, m)
              + solve(dp, grid, 0, 0, 1, n, m)) % MOD;
    }

    int solve(int[][][] dp, int[][] grid,
              int row, int col, int dir, int n, int m) {

        if (row >= n || col >= m) {
            return 0;
        }

        if (row == n - 1 && col == m - 1) {
            return 1;
        }

        if (dp[row][col][dir] != -1) {
            return dp[row][col][dir];
        }

        int ans = 0;

        if (grid[row][col] == 1) {

            if (dir == 0) {
                ans = solve(dp, grid, row + 1, col, 1, n, m);
            } else {
                ans = solve(dp, grid, row, col + 1, 0, n, m);
            }

        } else {

            if (row == 0 && col == 0) {
                if (dir == 0) {
                    ans = solve(dp, grid, row, col + 1, 0, n, m);
                } else {
                    ans = solve(dp, grid, row + 1, col, 1, n, m);
                }
            } else {
                int right = solve(dp, grid, row, col + 1, 0, n, m);
                int down = solve(dp, grid, row + 1, col, 1, n, m);

                ans = (right + down) % MOD;
            }
        }

        return dp[row][col][dir] = ans;
    }
}