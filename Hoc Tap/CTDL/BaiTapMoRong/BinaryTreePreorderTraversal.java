package LeetCode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
	/*
	 * Tra ve goc cay khong co null
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

	// So lan sai:1
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		themPhanTuVaoList(list, root);
		return list;
	}
	
	public static void themPhanTuVaoList(List<Integer> list, TreeNode root) {
		if (root == null)
			return;
		list.add(root.val);
		themPhanTuVaoList(list, root.left);
		themPhanTuVaoList(list, root.right);
	}

}
