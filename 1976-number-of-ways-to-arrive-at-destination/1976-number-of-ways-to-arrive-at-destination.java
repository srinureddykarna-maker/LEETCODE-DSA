class pair {
    long dist;
    int node;

    pair(long dist, int node) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }

        long[] dist = new long[n];
        int[] ways = new int[n];

        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.dist, b.dist)
        );

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new pair(0, 0));

        long MOD = 1000000007;

        while (!pq.isEmpty()) {

            int node = pq.peek().node;
            long dis = pq.peek().dist;

            pq.remove();

            for (int[] edge : adj.get(node)) {

                int adjnode = edge[0];
                int adjdis = edge[1];

                if (dis + adjdis < dist[adjnode]) {

                    dist[adjnode] = dis + adjdis;

                    pq.add(new pair(dis + adjdis, adjnode));

                    ways[adjnode] = ways[node];

                } else if (dis + adjdis == dist[adjnode]) {

                    ways[adjnode] =
                        (int)((ways[adjnode] + (long)ways[node]) % MOD);
                }
            }
        }

        return ways[n - 1];
    }
}