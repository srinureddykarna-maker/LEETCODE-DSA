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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
       if(root == null ){
        return -1;
       }
       Queue<TreeNode> q =new LinkedList<>();
       q.add(root);
       ans.add(root.val);
       while(!q.isEmpty()){
        TreeNode cur = q.poll();
        if(cur.left != null){
            q.add(cur.left);
            ans.add(cur.left.val);   
        }
        if(cur.right != null){
            q.add(cur.right);
            ans.add(cur.right.val);
        }
       }
      
        Collections.sort(ans);

        return ans.get(k - 1);

    }
}