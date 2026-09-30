class tuple {
    int stop;
    int node;
    int dis;

    tuple(int stop, int node, int dis) {
        this.stop = stop;
        this.node = node;
        this.dis = dis;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            adj.get(from).add(new int[]{to, price});
        }

        Queue<tuple> q = new LinkedList<>();

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        q.add(new tuple(0, src, 0));

        while (!q.isEmpty()) {

            int stop = q.peek().stop;
            int node = q.peek().node;
            int dis = q.peek().dis;

            q.remove();

            if (stop > k) {
                continue;
            }

            // Copy current distances
            int[] temp = dist.clone();

            for (int[] it : adj.get(node)) {

                int nextnode = it[0];
                int price = it[1];

                if (dis + price < temp[nextnode]) {

                    temp[nextnode] = dis + price;

                    q.add(new tuple(
                        stop + 1,
                        nextnode,
                        dis + price
                    ));
                }
            }

            dist = temp;
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dst];
    }
}