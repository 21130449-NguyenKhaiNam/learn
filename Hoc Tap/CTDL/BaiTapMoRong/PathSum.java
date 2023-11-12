package LeetCode;

public class PathSum {
	/*
	 * Tim xem trong cay co tong duong nao bang so bo vao khong, kiem tra cac truong
	 * hop dac biet, thuc hien viec tru neu ra 0 thi da dung va vi duoi ket qua su
	 * dung toan so sanh Or nen chi can 1 cho dung la du
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

	// So lan sai: 2
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		int s = targetSum - root.val;
		if (s == 0 && root.left == null && root.right == null)
			return true;
		return hasPathSum(root.left, s) || hasPathSum(root.right, s);
	}
}
