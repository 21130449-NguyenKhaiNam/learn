package LeetCode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	/*
	 * Cho cau truc cay nhi phan,tra ve danh sach cac nhan tinh tu trai qua phai
	 * Su dung de quy
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

	// So lan sai: 0
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorderTraversal = new ArrayList<Integer>();
		if (root == null) 
			return inorderTraversal;
		themGiaTri(inorderTraversal, root);
		return inorderTraversal;
	}

	public static void themGiaTri(List<Integer> inorderTraversal, TreeNode rootThat) {
		if (rootThat != null) {
			themGiaTri(inorderTraversal, rootThat.left);
			inorderTraversal.add(rootThat.val);
			themGiaTri(inorderTraversal, rootThat.right);
		}
	}
}
