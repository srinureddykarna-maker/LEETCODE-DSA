
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        int[] head = new int[n];
        int[] next = new int[n];
        Arrays.fill(head, -1);

        // Store children using arrays
        for (int i = 1; i < n; i++) {
            next[i] = head[parent[i]];
            head[parent[i]] = i;
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] previous = new int[n];

        int[] stack = new int[2 * n];
        int[] state = new int[2 * n];

        int top = 0;
        stack[top] = 0;
        state[top++] = 0;

        while (top > 0) {
            top--;

            int node = stack[top];
            int type = state[top];

            int ch = s.charAt(node) - 'a';

            if (type == 0) {
                // Enter node
                previous[node] = last[ch];
                last[ch] = node;

                // Exit event
                stack[top] = node;
                state[top++] = 1;

                // Visit original children
                for (int child = head[node];
                     child != -1;
                     child = next[child]) {

                    stack[top] = child;
                    state[top++] = 0;
                }

            } else {
                // Exit node: calculate its final parent
                int p = previous[node];

                if (p == -1) {
                    p = parent[node];
                }

                if (p != -1) {
                    ans[p] += ans[node];
                }

                // Restore previous ancestor
                last[ch] = previous[node];
            }
        }

        return ans;
    }
}
