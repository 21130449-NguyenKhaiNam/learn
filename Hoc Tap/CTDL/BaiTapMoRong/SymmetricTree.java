package LeetCode;

public class SymmetricTree {
	/*
	 * Cho mot cay nhi phan tinh theo dang dau trai phai Kiem tra hai ben doi xung
	 * co bang nhau
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

	// So lan sai:2
	public boolean isSymmetric(TreeNode root) {
		return isSameTree(root.left, root.right);
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (q == null || p == null)
			return false;
		if(p.val == q.val)
			return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
		return false;
	}
}
