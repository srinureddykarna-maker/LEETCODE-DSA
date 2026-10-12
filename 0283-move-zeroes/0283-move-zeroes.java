class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left =0;
        int right =0;
        while(left<n){
            if(nums[left]!=0){
                int  temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right++;
            }
            left++;
            
        }
        
    }
}