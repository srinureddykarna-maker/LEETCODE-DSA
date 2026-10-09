class Solution {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int req=1;
       
        while(true){
            int sum = req;
            boolean valid = true;
        for(int i=0;i<n;i++){
             sum = sum + nums[i];
            if(sum<=0){
                valid = false;
                
                break;

            }
        }
        if(valid){
            return req;
        }
        req++;
        }
        
        
    }
}