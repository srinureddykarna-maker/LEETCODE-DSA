import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        int n = nums.length;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int i = 0;
        int ans = 0;

        for (int j = 0; j < n; j++) {

            // Maintain decreasing order for maximum
            while (!maxDeque.isEmpty() &&
                   nums[maxDeque.peekLast()] <= nums[j]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(j);

            // Maintain increasing order for minimum
            while (!minDeque.isEmpty() &&
                   nums[minDeque.peekLast()] >= nums[j]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(j);

            // Shrink window if invalid
            while (nums[maxDeque.peekFirst()] -
                   nums[minDeque.peekFirst()] > limit) {

                if (maxDeque.peekFirst() == i) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == i) {
                    minDeque.pollFirst();
                }

                i++;
            }

            // Update longest valid window
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}