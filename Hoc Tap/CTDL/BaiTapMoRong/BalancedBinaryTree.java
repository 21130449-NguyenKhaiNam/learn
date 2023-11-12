package LeetCode;

public class BalancedBinaryTree {
	/*
	 * Kiem tra cay nhi phan co can bang khong, cay nhi phan can bang can tinh ca cac cay con
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

	// So lan sai: 10
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return (Math.abs(chieuCaoCay(root.left, 1) - chieuCaoCay(root.right, 1)) <= 1) && isBalanced(root.left)
				&& isBalanced(root.right);
	}

	public int chieuCaoCay(TreeNode root, int h) {
		if (root == null)
			return h - 1;
		int h2 = ++h;
		return Math.max(chieuCaoCay(root.left, h), chieuCaoCay(root.right, h2));
	}
}
