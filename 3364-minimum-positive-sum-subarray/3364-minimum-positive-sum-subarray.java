
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int min = Integer.MAX_VALUE;

        int i = 0;

        while (i < n) {
            int sum = 0;
            int j = i;

            while (j < n && j - i + 1 <= r) {
                sum += nums.get(j);

                int len = j - i + 1;

                if (len >= l && sum > 0) {
                    min = Math.min(min, sum);
                }

                j++;
            }

            i++;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
