package tree;

public class test2 {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.add(25);
		bst.add(15);
		bst.add(50);
		bst.add(10);
		bst.add(22);
		bst.add(4);
		bst.add(12);
		bst.add(18);
		bst.add(24);
		bst.add(35);
		bst.add(70);
		bst.add(31);
		bst.add(44);
		bst.add(66);
		bst.add(90);

		System.out.print("Inorder: ");
		bst.inorder();

		System.out.println("\n" + "-----------------------------------------------------------");

		System.out.print("Preorder: ");
		bst.preorder();

		System.out.println("\n" + "-----------------------------------------------------------");

		System.out.print("Postorder: ");
		bst.postorder();
	}
}
