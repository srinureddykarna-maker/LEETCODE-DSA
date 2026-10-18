class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxlength = 0;
        int i = 0;
        map.put(0,-1);
        while(i<nums.length){
            if(nums[i]==0){
                sum--;
            }else{
                sum++;
            }

            if(map.containsKey(sum)){
                int length = i - map.get(sum);
                maxlength = Math.max(length,maxlength);
            }else{
                map.put(sum,i);
            }
            i++;
        }


        return maxlength;
    }
}