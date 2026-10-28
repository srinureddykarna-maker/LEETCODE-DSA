import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        BitSet[][] dp = new BitSet[n][m];

        return solve(dp, grid, n - 1, m - 1).nextSetBit(0);
    }

    BitSet solve(BitSet[][] dp, int[][] grid, int i, int j) {
        if (i < 0 || j < 0) {
            return new BitSet();
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        BitSet result = new BitSet();

        if (i == 0 && j == 0) {
            result.set(grid[0][0]);
            return dp[i][j] = result;
        }

        BitSet up = solve(dp, grid, i - 1, j);
        BitSet left = solve(dp, grid, i, j - 1);

        for (int x = up.nextSetBit(0);
             x >= 0;
             x = up.nextSetBit(x + 1)) {
            result.set(x ^ grid[i][j]);
        }

        for (int x = left.nextSetBit(0);
             x >= 0;
             x = left.nextSetBit(x + 1)) {
            result.set(x ^ grid[i][j]);
        }

        return dp[i][j] = result;
    }
}