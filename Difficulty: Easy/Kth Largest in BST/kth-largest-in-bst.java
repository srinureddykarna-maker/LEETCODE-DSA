/* Structure of a Binary Tree Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};*/

class Solution {
    int count =0;
    int k;
    int result;
    public int kthLargest(Node root, int k) {
        if(root == null) return 0;
        this.k = k;
        reverseorder(root);
        // code here
        return result;
    }
    public void reverseorder(Node root)
    {
        if (root == null) {
                    return;
                }
        reverseorder(root.right);
        count++;
        if(count==k)
        {
            result =root.data;
            return;
        }
        reverseorder(root.left);
    }
}