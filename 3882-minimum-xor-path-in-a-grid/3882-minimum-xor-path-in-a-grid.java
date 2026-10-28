class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][][] dp = new boolean[n][m][1024];
        boolean[][] visited = new boolean[n][m];

        solve(dp, visited, grid, n - 1, m - 1);

        for (int x = 0; x < 1024; x++) {
            if (dp[n - 1][m - 1][x]) {
                return x;
            }
        }

        return -1;
    }

    void solve(boolean[][][] dp, boolean[][] visited,
               int[][] grid, int i, int j) {

        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || j < 0) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        if (i == 0 && j == 0) {
            dp[0][0][grid[0][0]] = true;
            return;
        }

        solve(dp, visited, grid, i - 1, j);
        solve(dp, visited, grid, i, j - 1);

        int val = grid[i][j];

        if (i > 0) {
            for (int x = 0; x < 1024; x++) {
                if (dp[i - 1][j][x]) {
                    dp[i][j][x ^ val] = true;
                }
            }
        }

        if (j > 0) {
            for (int x = 0; x < 1024; x++) {
                if (dp[i][j - 1][x]) {
                    dp[i][j][x ^ val] = true;
                }
            }
        }
    }
}