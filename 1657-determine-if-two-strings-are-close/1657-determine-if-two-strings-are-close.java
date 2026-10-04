class Solution {
    public boolean closeStrings(String word1, String word2) {

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int n = word1.length();
        int m = word2.length();
        if(n!=m) return false;
        for(int i=0;i<n;i++){
            char c = word1.charAt(i);
            char d = word2.charAt(i);
            freq1[c - 'a'] ++;
            freq2[d - 'a'] ++;
        }
        for(int i = 0; i < 26; i++) {
              if((freq1[i] == 0) != (freq2[i] == 0)) {
        return false;
                 }
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
}