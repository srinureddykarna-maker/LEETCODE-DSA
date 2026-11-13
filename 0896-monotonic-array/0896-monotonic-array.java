class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        boolean ans = true;
        boolean inc = true;
        boolean dec = true;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                dec = false;
                

            }else if(nums[i]<nums[i-1]){

                inc = false;
            }

        }
        return inc|| dec;
    }
}