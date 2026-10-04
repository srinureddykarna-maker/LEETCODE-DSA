class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int left = 0;
        int right = 0;

        int[] need = new int[26];
        int[] window = new int[26];
        int i=0;
         while(i < s1.length()) {
            need[s1.charAt(i) - 'a']++;
            i++;
        }
        //int left = 0;
        //int right =0;

        while(right<m){
            window[s2.charAt(right) - 'a']++;
            if(right-left+1 > n){
                window[s2.charAt(left)-'a']--;
                left++;
            }
            if(right-left+1 == n){
               if( Arrays.equals(need,window)){
                return true;
               }
               

            }
            right++;

        }
        return false;
    }
}