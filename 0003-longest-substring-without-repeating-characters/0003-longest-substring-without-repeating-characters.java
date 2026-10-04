class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int i=0;
        int j=0;
        int maxlen=0;
        while(j<n){
            char c = s.charAt(j);
            if(!set.contains(c)){
                set.add(c);
                maxlen = Math.max(maxlen, j-i + 1);
                j++;

                
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxlen;
    }
}