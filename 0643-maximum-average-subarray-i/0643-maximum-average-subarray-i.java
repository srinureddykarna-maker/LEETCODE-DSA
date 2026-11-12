class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        int i = 0;
        int j = 0;

        double sum = 0;
        double max = Double.NEGATIVE_INFINITY;

        while (j < n) {
            sum += nums[j];

            if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum -= nums[i];
                i++;
            }

            j++;
        }

        return max / k;
    }
}