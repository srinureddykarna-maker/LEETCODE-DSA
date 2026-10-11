class Solution {
    int houserobber(int[] nums){
        int n=nums.length;
        int prev1 = 0;
        int prev2 = 0;
        for(int i=0;i<n;i++){
            int pick = nums[i] + prev2;
            int nonpick = prev1;
            int curr = Math.max(pick,nonpick);
            prev2 = prev1 ;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        for(int i=0;i<n;i++){
            if(i>0) temp1[i-1] = nums[i];
            if(i<n-1) temp2[i] = nums[i];
        }
        return Math.max(houserobber(temp1),houserobber(temp2));
        
    }
}