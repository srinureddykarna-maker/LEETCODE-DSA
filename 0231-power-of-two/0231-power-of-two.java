class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        long result = 1;

        while (result < n) {
            result *= 2;
        }

        return result == n;
    }
}