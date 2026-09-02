/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        
        if (root == null) {
            return true;
        }

        int left;
        int right;

        if (root.left != null) {
            left = root.left.data;
        } else {
            left = 0;
        }

        if (root.right != null) {
            right = root.right.data;
        } else {
            right = 0;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.data != left + right) {
            return false;
        }

        return isSumProperty(root.left) && isSumProperty(root.right);
    }
}