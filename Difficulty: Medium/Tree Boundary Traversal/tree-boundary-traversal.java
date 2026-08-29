/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        // Root
        if (!isLeaf(root))
            result.add(root.data);

        // Left boundary
        leftBoundary(root.left, result);

        // Leaf nodes
        leaves(root, result);

        // Right boundary
        rightBoundary(root.right, result);

        return result;
    }

    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    void leftBoundary(Node node, ArrayList<Integer> result) {

        if (node == null || isLeaf(node))
            return;

        result.add(node.data);

        if (node.left != null)
            leftBoundary(node.left, result);
        else
            leftBoundary(node.right, result);
    }

    void leaves(Node node, ArrayList<Integer> result) {

        if (node == null)
            return;

        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }

        leaves(node.left, result);
        leaves(node.right, result);
    }

    void rightBoundary(Node node, ArrayList<Integer> result) {

        if (node == null || isLeaf(node))
            return;

        if (node.right != null)
            rightBoundary(node.right, result);
        else
            rightBoundary(node.left, result);

        result.add(node.data);
    }
}