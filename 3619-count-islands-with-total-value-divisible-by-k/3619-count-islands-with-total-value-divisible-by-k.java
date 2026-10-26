import java.util.*;

class pair {
    int row;
    int col;

    pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        int[] mrow = {1, 0, -1, 0};
        int[] mcol = {0, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 0 || visited[i][j] == 1) {
                    continue;
                }

                Queue<pair> q = new LinkedList<>();
                q.add(new pair(i, j));
                visited[i][j] = 1;

                long sum = 0;

                while (!q.isEmpty()) {
                    pair curr = q.remove();

                    int row = curr.row;
                    int col = curr.col;

                    sum += grid[row][col];

                    for (int d = 0; d < 4; d++) {
                        int nrow = row + mrow[d];
                        int ncol = col + mcol[d];

                        if (nrow >= 0 && nrow < n &&
                            ncol >= 0 && ncol < m &&
                            grid[nrow][ncol] != 0 &&
                            visited[nrow][ncol] == 0) {

                            visited[nrow][ncol] = 1;
                            q.add(new pair(nrow, ncol));
                        }
                    }
                }

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}