class Solution {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int minsum = 0;
        for(int i=0;i<n;i++){
            sum = sum + nums[i];
            minsum = Math.min(minsum,sum);


        }
        return 1-minsum;
        
    }
}