class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int i = 0;
        int j = 0;
        int l = Math.min(n, m);

        StringBuilder ans = new StringBuilder();

        while (i < l && j < l) {
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(j));

            i++;
            j++;
        }

        while (i < n) {
            ans.append(word1.charAt(i));
            i++;
        }

        while (j < m) {
            ans.append(word2.charAt(j));
            j++;
        }

        return ans.toString();
    }
}