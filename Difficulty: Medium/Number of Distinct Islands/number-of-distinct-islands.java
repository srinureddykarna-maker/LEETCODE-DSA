class Solution {

    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    private void dfs(int row, int col, char[][] grid,
                     int[][] vis, ArrayList<String> vec,
                     int baseRow, int baseCol) {

        vis[row][col] = 1;

        vec.add(toString(row - baseRow, col - baseCol));

        int n = grid.length;
        int m = grid[0].length;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {

            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                grid[nrow][ncol] == 'L' &&
                vis[nrow][ncol] == 0) {

                dfs(nrow, ncol, grid, vis, vec, baseRow, baseCol);
            }
        }
    }

    public int countDistinctIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        HashSet<ArrayList<String>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 'L' && vis[i][j] == 0) {

                    ArrayList<String> vec = new ArrayList<>();

                    dfs(i, j, grid, vis, vec, i, j);

                    st.add(vec);
                }
            }
        }

        return st.size();
    }
}