class tuple {
    int dist;
    int row;
    int col;

    tuple(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<tuple> q = new LinkedList<>();

        dist[0][0] = 1;
        q.add(new tuple(1, 0, 0));

        int[] drow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dcol = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!q.isEmpty()) {

            int dis = q.peek().dist;
            int row = q.peek().row;
            int col = q.peek().col;

            q.remove();

            if (row == n - 1 && col == n - 1) {
                return dis;
            }

            for (int i = 0; i < 8; i++) {

                int r = row + drow[i];
                int c = col + dcol[i];

                if (r >= 0 && r < n &&
                    c >= 0 && c < n &&
                    grid[r][c] == 0 &&
                    dis + 1 < dist[r][c]) {

                    dist[r][c] = dis + 1;

                    q.add(new tuple(dis + 1, r, c));
                }
            }
        }

        return -1;
    }
}