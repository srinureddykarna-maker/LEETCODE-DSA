import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {

        int maxLength = 0;
        int l = 0;
        int r = 0;
        int maxFrequency = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {

            char ch = s.charAt(r);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFrequency = Math.max(maxFrequency, map.get(ch));

            while ((r - l + 1) - maxFrequency > k) {

                char leftChar = s.charAt(l);

                map.put(leftChar, map.get(leftChar) - 1);

                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);

            r++;
        }

        return maxLength;
    }
}
