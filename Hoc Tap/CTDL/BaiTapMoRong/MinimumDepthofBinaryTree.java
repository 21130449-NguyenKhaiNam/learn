package LeetCode;

public class MinimumDepthofBinaryTree {
	/*
	 * Tim duong di ngan nhat tinh tu 0, Mot so truong hop dac biet can cho rieng,
	 * tim kiem vi tri ket thuc la so co left va right deu la null ngan nhat, Khi
	 * tim duoc vi tri tang len 1 don vi, 
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

	// So lan sai: 12
	//Cach khac
//	  if(root == null){
//          return 0;
//      }
//      
//      if(root.left == null && root.right ==null){
//          return 1;
//      }
//      else if( root.left != null && root.right == null){
//          return minDepth(root.left) + 1;
//      }
//      else if( root.left == null && root.right != null ){
//          return minDepth(root.right) + 1;
//      }
//      else{
//          return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
//      }
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		return 1 + Math.min(height(root.left, 1), height(root.right, 1));
	}

	public int height(TreeNode root, int h) {
		if (root == null)
			return Integer.MAX_VALUE;
		if (root.left == null && root.right == null)
			return h;
		++h;
		return Math.min(height(root.left, h), height(root.right, h));
	}

}
