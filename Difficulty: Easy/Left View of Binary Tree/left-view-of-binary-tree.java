/* Structure of Binary Tree Node
class Node {
	int data;
	Node left, right;
	
	Node(int val) {
		this.data = val;
		this.left = this.right = null;
	}
} */

class Solution {
	public ArrayList<Integer> leftView(Node root) {
		// code here
		ArrayList<Integer> result = new ArrayList<>();
		dfs(root, 0, result);
		return result;
		
	}
	private void dfs(Node root, int level, List<Integer> res) {
		if (root == null)
			return ;
		// if(res.size()<=level) res.add(new ArrayList<>());
		// res.get(level).add(root.val);
		if (res.size() <= level)
			res.add(root.data);
		dfs(root.left, level + 1, res);
		dfs(root.right, level + 1, res);
	}
}
