class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int i = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++) {
            sum += nums[j];
            while(sum >= target){
                min = Math.min(min,j-i+1);
                sum -= nums[i];
                i++;
            }
            

            

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}