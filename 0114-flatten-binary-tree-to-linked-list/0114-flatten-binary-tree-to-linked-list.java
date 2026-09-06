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
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> s= new Stack<>();
        s.push(root);
        while(!s.isEmpty())
        {
            TreeNode cur = s.pop();
            if(cur.right != null) s.push(cur.right);
            if(cur.left != null) s.push(cur.left);
            if(!s.isEmpty())
            {
                cur.right = s.peek();
                cur.left =null;
            }
        }
        
    }
}