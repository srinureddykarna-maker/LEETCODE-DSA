class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generate(nums,0,current,ans);
        return ans;
        
    }
    void generate(int[] nums,int index,List<Integer> current,List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        generate(nums,index+1,current,ans);
        current.remove(current.size()-1);
        generate(nums,index+1,current,ans);
    }
}