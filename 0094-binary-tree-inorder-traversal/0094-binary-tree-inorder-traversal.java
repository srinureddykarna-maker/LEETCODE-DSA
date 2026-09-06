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
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        TreeNode current = root;

        while (current != null) {

            // No left child
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            }

            // Left child exists
            else {
                // Find inorder predecessor
                TreeNode predecessor = current.left;

                while (predecessor.right != null &&
                       predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // Create temporary link
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }

                // Remove temporary link
                else {
                    predecessor.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }

        return result;
    }
}