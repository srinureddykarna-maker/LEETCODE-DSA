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
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<tuple> pq =
            new PriorityQueue<>((x, y) -> Integer.compare(x.dist, y.dist));

        dist[0][0] = 0;
        pq.add(new tuple(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {

            tuple curr = pq.poll();

            int diff = curr.dist;
            int row = curr.row;
            int col = curr.col;

            if (row == n - 1 && col == m - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {

                int r = row + dr[i];
                int c = col + dc[i];

                if (r >= 0 && r < n && c >= 0 && c < m) {

                    int neweffort = Math.max(
                        diff,
                        Math.abs(heights[row][col] - heights[r][c])
                    );

                    if (neweffort < dist[r][c]) {

                        dist[r][c] = neweffort;

                        pq.add(new tuple(neweffort, r, c));
                    }
                }
            }
        }

        return 0;
    }
}