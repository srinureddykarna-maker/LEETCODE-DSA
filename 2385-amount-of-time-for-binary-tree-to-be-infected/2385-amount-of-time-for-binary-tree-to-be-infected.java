/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public void markParent(TreeNode root, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if (current.left != null) {
                parent.put(current.left, current);
                q.offer(current.left);
            }

            if (current.right != null) {
                parent.put(current.right, current);
                q.offer(current.right);
            }
        }
    }

    public TreeNode findStart(TreeNode root, int start) {
        if (root == null) {
            return null;
        }

        if (root.val == start) {
            return root;
        }

        TreeNode left = findStart(root.left, start);

        if (left != null) {
            return left;
        }

        return findStart(root.right, start);
    }

    public int amountOfTime(TreeNode root, int start) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);

        TreeNode target = findStart(root, start);

        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();

        q.offer(target);
        visited.put(target, true);

        int time = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {

                TreeNode current = q.poll();

                if (current.left != null &&
                    !visited.containsKey(current.left)) {

                    q.offer(current.left);
                    visited.put(current.left, true);
                    burned = true;
                }

                if (current.right != null &&
                    !visited.containsKey(current.right)) {

                    q.offer(current.right);
                    visited.put(current.right, true);
                    burned = true;
                }

                if (parent.containsKey(current) &&
                    !visited.containsKey(parent.get(current))) {

                    q.offer(parent.get(current));
                    visited.put(parent.get(current), true);
                    burned = true;
                }
            }

            if (burned) {
                time++;
            }
        }

        return time;
    }
}