import java.util.*;

class Solution {

    class MultiSet {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = 0;
        long sum = 0;

        void add(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            size++;
            sum += val;
        }

        void remove(int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }

            size--;
            sum -= val;
        }

        int getMin() {
            return map.firstKey();
        }

        int getMax() {
            return map.lastKey();
        }
    }

    class Window {
        MultiSet lower = new MultiSet();
        MultiSet upper = new MultiSet();

        void add(int val) {
            if (lower.size == 0) {
                if (upper.size > 0 && val > upper.getMin()) {
                    upper.add(val);
                } else {
                    lower.add(val);
                }
            } else if (val <= lower.getMax()) {
                lower.add(val);
            } else {
                upper.add(val);
            }
        }

        void remove(int val) {
            if (lower.map.containsKey(val)) {
                lower.remove(val);
            } else {
                upper.remove(val);
            }
        }

        void rebalance() {
            int total = lower.size + upper.size;
            int target = (total + 1) / 2;

            while (lower.size > target) {
                int val = lower.getMax();
                lower.remove(val);
                upper.add(val);
            }

            while (lower.size < target) {
                int val = upper.getMin();
                upper.remove(val);
                lower.add(val);
            }
        }

        long getCost() {
            long median = lower.getMax();
            long left = median * lower.size - lower.sum;
            long right = upper.sum - median * upper.size;
            return left + right;
        }
    }

    private long[] getCosts(int[] nums, int x) {
        int n = nums.length;
        long[] costs = new long[n - x + 1];

        Window window = new Window();

        for (int i = 0; i < n; i++) {
            if (i >= x) {
                window.remove(nums[i - x]);
            }

            window.add(nums[i]);
            window.rebalance();

            if (i >= x - 1) {
                costs[i - x + 1] = window.getCost();
            }
        }

        return costs;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] costs = getCosts(nums, x);

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];

                if (i >= x && dp[i - x][j - 1] != INF) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + costs[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}