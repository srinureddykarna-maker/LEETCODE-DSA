class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int even = 1;
        int odd = 0;
        int count = 0;
        int sum = 0;
        int mod = 1000000007;

        for(int i = 0; i < n; i++) {
            sum += arr[i];

            if(sum % 2 == 0) {
                even++;
                count = (count + odd) % mod;
            } else {
                odd++;
                count = (count + even) % mod;
            }
        }

        return count;
    }
}