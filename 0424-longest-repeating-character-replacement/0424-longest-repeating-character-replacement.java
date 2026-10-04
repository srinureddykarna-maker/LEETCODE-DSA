class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int right = 0;

        int maxFrequency = 0;
        int maxLength = 0;

        while(right < s.length()) {

            int index = s.charAt(right) - 'A';

            freq[index]++;

            maxFrequency = Math.max(maxFrequency, freq[index]);

            while((right - left + 1) - maxFrequency > k) {

                int leftIndex = s.charAt(left) - 'A';

                freq[leftIndex]--;

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }
}