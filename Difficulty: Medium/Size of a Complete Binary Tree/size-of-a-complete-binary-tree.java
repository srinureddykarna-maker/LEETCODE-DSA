class Solution {

    public int countNodes(Node root) {
        if(root == null ) return 0;
        int left = getheightleft(root);
        int right = getheightright(root);
        
        if(left == right) return ((2<<(left))-1);
         else 
         {
             return countNodes(root.left)+countNodes(root.right)+1;
         }
        
    }
    public int getheightleft(Node root)
    {
        int count =0 ;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }
    public int getheightright(Node  root)
    {
        int count = 0;
        while(root.right != null)
        {
            count++;
            root = root.right;
        }
        return count;
    }
}