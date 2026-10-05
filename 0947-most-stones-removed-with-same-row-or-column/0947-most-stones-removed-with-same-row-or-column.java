class Solution {

    int[] parent;
    int[] size;

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) {
            return;
        }

        if (size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
    }

    public int removeStones(int[][] stones) {

        int n = stones.length;

        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

       
        int totalNodes = maxRow + maxCol + 2;

        parent = new int[totalNodes];
        size = new int[totalNodes];

        for (int i = 0; i < totalNodes; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        HashMap<Integer, Integer> stoneNode = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;

            union(nodeRow, nodeCol);

            stoneNode.put(nodeRow, 1);
            stoneNode.put(nodeCol, 1);
        }

        int cnt = 0;

        for (Map.Entry<Integer, Integer> it : stoneNode.entrySet()) {
            if (find(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }

        return n - cnt;
    }
}