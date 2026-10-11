class Solution {
    public int rob(int[] nums) {
        int n  = nums.length;
       int prev2 = 0;
       int prev1 = 0;
       for(int i=0;i<n;i++){
        int pick = nums[i] + prev2;
        int nonpick = prev1;
        int curr = Math.max(pick,nonpick);
        prev2 = prev1;
        prev1 = curr;
       }
       return prev1;

        
    }
}