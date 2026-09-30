class Tuple {
    int first, second, third;

    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0])
               .add(new int[]{flights[i][1], flights[i][2]});
        }

        Queue<Tuple> q = new LinkedList<>();

        // {stops, node, cost}
        q.add(new Tuple(0, src, 0));

        int[] dist = new int[n];

        Arrays.fill(dist, (int)(1e9));

        dist[src] = 0;

        while (!q.isEmpty()) {

            Tuple it = q.remove();

            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if (stops > k)
                continue;

            for (int[] edge : adj.get(node)) {

                int adjNode = edge[0];
                int edW = edge[1];

                if (cost + edW < dist[adjNode] && stops <= k) {

                    dist[adjNode] = cost + edW;

                    q.add(new Tuple(
                        stops + 1,
                        adjNode,
                        cost + edW
                    ));
                }
            }
        }

        if (dist[dst] == (int)(1e9))
            return -1;

        return dist[dst];
    }
}

