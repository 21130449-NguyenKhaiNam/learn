package LeetCode;
import java.util.ArrayList;
import java.util.List;

public class SameTree {
	/*
	 * Cho hai cay nhi phan kiem tra no co bang nhau, them theo dang dau trai phai
	 * ke ca null cung them
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
	
	//Cach khac
	  // p and q are both null
//    if (p == null && q == null) return true;
//    // one of p and q is null
//    if (q == null || p == null) return false;
//    if (p.val != q.val) return false;
//    return isSameTree(p.right, q.right) &&
//            isSameTree(p.left, q.left);

	// So lan sai: 4
	public boolean isSameTree(TreeNode p, TreeNode q) {
		List<Integer> root_1 = inorderTraversal(p);
		List<Integer> root_2 = inorderTraversal(q);
		return root_1.equals(root_2);
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorderTraversal = new ArrayList<Integer>();
		if (root == null)
			return inorderTraversal;
		themGiaTri(inorderTraversal, root);
		return inorderTraversal;
	}

	public static void themGiaTri(List<Integer> inorderTraversal, TreeNode rootThat) {
		if (rootThat != null) {
			inorderTraversal.add(rootThat.val);
			themGiaTri(inorderTraversal, rootThat.left);
			themGiaTri(inorderTraversal, rootThat.right);
		} else {
			inorderTraversal.add(null);
		}
	}
}
