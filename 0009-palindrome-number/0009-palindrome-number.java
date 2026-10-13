
class Solution {

    public boolean isPalindrome(int num) {

        String s = String.valueOf(num);
        return check(s, 0, s.length() - 1);
    }

    public boolean check(String s, int left, int right) {

        // Base case
        if (left >= right) {
            return true;
        }

        // If characters don't match
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        // Recursive call
        return check(s, left + 1, right - 1);
    }

}