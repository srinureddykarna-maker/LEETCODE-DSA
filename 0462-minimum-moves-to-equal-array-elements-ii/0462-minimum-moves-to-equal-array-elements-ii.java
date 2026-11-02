class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        int mid = nums[n/2];
      /*  if(n%2 == 0){
            mid = nums[n/2];
        }else{
            mid = nums[(n/2)+((n-1)/2)];
        }*/
        int steps = 0;
        for(int i=0;i<n;i++){
            steps += Math.abs(mid - nums[i]); 
        }
        return steps;
        
    }
}