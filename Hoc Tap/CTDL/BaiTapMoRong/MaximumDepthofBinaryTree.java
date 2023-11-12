package LeetCode;

public class MaximumDepthofBinaryTree {
	/*
	 * Tra ve level toi da cua cay nhi phan tinh tu 1
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

	//So lan sai: 5
    public int maxDepth(TreeNode root) {
        if(root.left == null && root.right == null)
        	return 0;
        int chieuDaiTrai = chieuDaiCay(root.left, 1);
        int chieuDaiPhai = chieuDaiCay(root.right, 1);
        return Math.max(chieuDaiTrai, chieuDaiPhai);
    }
    
    public int chieuDaiCay(TreeNode root, int count) {
    	if(root == null)
    		return count;
    	int count2 = count;
    	return Math.max(chieuDaiCay(root.left, ++count), chieuDaiCay(root.right, count2));
    }
}
