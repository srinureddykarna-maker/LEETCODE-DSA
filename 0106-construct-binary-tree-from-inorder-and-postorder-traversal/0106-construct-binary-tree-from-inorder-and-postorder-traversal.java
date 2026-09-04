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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
        {
            int key = inorder[i];
            map.put(key,i);
        }
        return build(postorder,0 ,postorder.length-1 ,inorder,0,inorder.length-1,map);
    }
    public TreeNode build(int[] postorder,int postart,int postend,int[] inorder,int instart,int inend,Map<Integer,Integer>map){
        if(postart>postend || instart>inend) return null;
        TreeNode root = new TreeNode(postorder[postend]);
        int inroot = map.get(root.val);
        int numsleft = inroot - instart;
        root.left = build(postorder, postart,postart+numsleft-1,inorder,instart,instart +numsleft-1,map);
        root.right = build(postorder,numsleft+postart,postend-1,inorder,inroot+1,inend,map);
        return root;

    }
}