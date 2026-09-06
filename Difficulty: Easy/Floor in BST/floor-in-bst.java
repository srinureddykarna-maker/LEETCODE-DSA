/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int findMaxFork(Node root, int k) {
        // code here.
        // code here
                int ceil = -1;
                while(root != null ){

                    if(root.data==k)
                    {
                       ceil= root.data;
                        return ceil;
                    }
                    if(k<root.data)
                    {
                        root = root.left;
                    }else {
                        ceil = root.data;
                        root = root.right;
                }
                }
                return ceil;
    }
}