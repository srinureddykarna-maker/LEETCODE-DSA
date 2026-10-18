class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
        
    }
    private void mergesort(int[] nums,int low,int high){
        if(low>=high){
            return;
        }
        int mid = low+(high-low)/2;
        mergesort(nums,low,mid);
        mergesort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    private void merge(int[] nums,int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=high){
            if(nums[i] <= nums[j]){
                temp[k] = nums[i];
                i++;
            }else{
                temp[k] = nums[j];
                j++;
            }
            k++;
        }
         while(i <= mid){
            temp[k] = nums[i];
            i++;
            k++;
         }
         while(j<=high){
            temp[k] = nums[j];
            j++;
            k++;

         }
         for(int x = 0 ;x<temp.length;x++){
            nums[low+x] = temp[x];
         }

    }
}