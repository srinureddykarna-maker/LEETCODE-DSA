class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int n = nums.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            answer[i] = left;
            left = left*nums[i];
        }
        int right=1;
        for(int i=n-1;i>=0;i--){
            answer[i] = right*answer[i];
            right = right*nums[i];
        }
        return answer;
    }
}