package LeetCode;

public class InvertBinaryTree {
	/*
	 * Dao mot cay nhi phan
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	/*
	 * Huong lam: Dao left right bang de quy.
	 */
	public TreeNode invertTree(TreeNode root) {
		/*
		 * Cach khac if(root==null)return null; TreeNode left=invertTree(root.left);
		 * TreeNode right=invertTree(root.right); root.left=right; root.right=left;
		 * return root;
		 */
		if (root == null || root.left == null && root.right == null) {
			return root;
		} else {
			invertTree(root.left);
			invertTree(root.right);
			TreeNode tn = new TreeNode();
			tn = root.left;
			root.left = root.right;
			root.right = tn;
			return root;
		}

	}
}
