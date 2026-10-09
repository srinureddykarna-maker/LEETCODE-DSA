class Solution {
    public int pivotIndex(int[] nums) {
        int left =0;
        int right =0;
        int totalsum =0;
        for(int i=0;i<nums.length;i++){
            totalsum = totalsum + nums[i];

        }
        for(int i=0;i<nums.length;i++){
            if(i>0){
                left = left + nums[i-1];
            }
            
            right = totalsum - left - nums[i];
            if(left == right) return i;
        }
        return -1;
            }
}