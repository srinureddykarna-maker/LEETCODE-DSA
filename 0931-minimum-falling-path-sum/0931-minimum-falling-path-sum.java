class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] prev = new int[m];

        for (int j = 0; j < m; j++) {
            prev[j] = grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[m];

            for (int j = 0; j < m; j++) {
                int u = grid[i][j] + prev[j];

                int sl = Integer.MAX_VALUE;
                if (j > 0) {
                    sl = grid[i][j] + prev[j - 1];
                }

                int sr = Integer.MAX_VALUE;
                if (j < m - 1) {
                    sr = grid[i][j] + prev[j + 1];
                }

                curr[j] = Math.min(u, Math.min(sl, sr));
            }

            prev = curr;
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, prev[j]);
        }

        return ans;
    }
}