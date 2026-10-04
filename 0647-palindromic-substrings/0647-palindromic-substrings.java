class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int i = 0;
        int count = 0;
        while(i<n){
            int left = i;
            int right = i;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
            left =i;
            right = i+1;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
            i++;
        }
        return count;
        
    }
}