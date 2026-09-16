class Pair {
    int r;
    int c;
    int d;

    Pair(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] visited = new int[n][m];
        int[][] ans = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        // Put all 0s into the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};

        // BFS
        while (!q.isEmpty()) {

            Pair p = q.poll();

            int r = p.r;
            int c = p.c;
            int d = p.d;

            ans[r][c] = d;

            // Check 4 directions
            for (int i = 0; i < 4; i++) {

                int nr = r + drow[i];
                int nc = c + dcol[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    visited[nr][nc] == 0) {

                    visited[nr][nc] = 1;

                    q.add(new Pair(nr, nc, d + 1));
                }
            }
        }

        return ans;
    }
}