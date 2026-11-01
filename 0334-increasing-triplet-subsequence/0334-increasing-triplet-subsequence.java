class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int n = nums.length;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int num:nums){
            if(num<= first){
                first = num;
            }else if(num<= second){
                second = num;
            }else{
                return true;
            }
        }
        return false;
        
    }
}