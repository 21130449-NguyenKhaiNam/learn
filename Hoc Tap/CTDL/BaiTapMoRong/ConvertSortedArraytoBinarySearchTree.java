package LeetCode;

public class ConvertSortedArraytoBinarySearchTree {
	/*
	 * Chuyen doi mang da sap xep thanh cay nhi phan can bang
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
	// bai cua nguoi khac
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public TreeNode helper(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int mid = (left + right) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, left, mid - 1);
		node.right = helper(nums, mid + 1, right);
		return node;
	}
}
