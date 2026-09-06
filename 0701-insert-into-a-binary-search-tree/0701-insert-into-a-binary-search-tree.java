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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null ) return new TreeNode(val);
        TreeNode s = root;
        while(true){
            if(s.val<=val) { 
            if(s.right != null){
                s = s.right;
            }else {s.right= new TreeNode(val);
             break;}
            }
            else{ 
            if(s.left != null)
            {
                s = s.left;
            }else {s.left= new TreeNode(val); 
            break;}
     
               }
                  }
                  return root;
    }
}