class pair {
    int row;
    int col;

    pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int cntOnes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        q.add(new pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int nrow = q.peek().row;
            int ncol = q.peek().col;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int r = nrow + delrow[i];
                int c = ncol + delcol[i];

                if (r >= 0 && r < n && c >= 0 && c < m
                        && grid[r][c] == 1 && vis[r][c] == 0) {

                    q.add(new pair(r, c));
                    vis[r][c] = 1;
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}