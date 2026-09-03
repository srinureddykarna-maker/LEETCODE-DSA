/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public void markcheck(TreeNode root, Map<TreeNode, TreeNode> parentrack) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if (current.left != null) {
                q.offer(current.left);
                parentrack.put(current.left, current);
            }

            if (current.right != null) {
                q.offer(current.right);
                parentrack.put(current.right, current);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentrack = new HashMap<>();
        markcheck(root, parentrack);

        Map<TreeNode, Boolean> visit = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(target);
        visit.put(target, true);

        int currLevel = 0;

        while (!q.isEmpty()) {
            if (currLevel == k) {
                break;
            }

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();

                if (current.left != null && !visit.containsKey(current.left)) {
                    q.offer(current.left);
                    visit.put(current.left, true);
                }

                if (current.right != null && !visit.containsKey(current.right)) {
                    q.offer(current.right);
                    visit.put(current.right, true);
                }

                if (parentrack.containsKey(current) &&
                    !visit.containsKey(parentrack.get(current))) {

                    q.offer(parentrack.get(current));
                    visit.put(parentrack.get(current), true);
                }
            }

            currLevel++;
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }
}