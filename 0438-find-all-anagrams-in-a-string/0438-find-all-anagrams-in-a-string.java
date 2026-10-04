class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        if(n<m) return ans;
       int left =0;
       int right = 0;
       int[] need = new int[26];
       int[] window = new int[26];
       int i=0;
       while(i < m) {
            need[p.charAt(i) - 'a']++;
            i++;
        }
       // int left =0 ;
        //int right =0;
       while(right<n){
         window[s.charAt(right) - 'a']++;
         if(right-left+1 > m){
            window[s.charAt(left)-'a']--;
            left++;
         }
         if(right-left+1 == m){
            if(Arrays.equals(need,window)){
                ans.add(left);
            }
         }
         right++;
       }
        return ans;
        
    }
}