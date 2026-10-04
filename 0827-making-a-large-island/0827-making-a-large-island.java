class Solution {

    int[] parent;
    int[] size;

    int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int u, int v) {

        int rootu = find(u);
        int rootv = find(v);

        if(rootu == rootv) {
            return;
        }

        // Smaller component joins larger component
        if(size[rootu] < size[rootv]) {
            parent[rootu] = rootv;
            size[rootv] += size[rootu];
        }
        else {
            parent[rootv] = rootu;
            size[rootu] += size[rootv];
        }
    }

    boolean isvalid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;

        parent = new int[n * n];
        size = new int[n * n];

        // Initialize DSU
        for(int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // Step 1: Create connected components of 1s
        for(int r = 0; r < n; r++) {

            for(int c = 0; c < n; c++) {

                if(grid[r][c] == 0) {
                    continue;
                }

                int node = r * n + c;

                for(int i = 0; i < 4; i++) {

                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(isvalid(nr, nc, n) && grid[nr][nc] == 1) {

                        int adjnode = nr * n + nc;

                        union(node, adjnode);
                    }
                }
            }
        }

        int mx = 0;

        // Step 2: Try converting every 0 into 1
        for(int r = 0; r < n; r++) {

            for(int c = 0; c < n; c++) {

                if(grid[r][c] == 1) {
                    continue;
                }

                HashSet<Integer> components = new HashSet<>();

                for(int i = 0; i < 4; i++) {

                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(isvalid(nr, nc, n) && grid[nr][nc] == 1) {

                        int node = nr * n + nc;

                        components.add(find(node));
                    }
                }

                // Convert current 0 -> 1
                int currentSize = 1;

                for(int root : components) {
                    currentSize += size[root];
                }

                mx = Math.max(mx, currentSize);
            }
        }

        // Step 3: Grid may already contain all 1s
        for(int i = 0; i < n * n; i++) {

            if(grid[i / n][i % n] == 1) {

                mx = Math.max(mx, size[find(i)]);
            }
        }

        return mx;
    }
}