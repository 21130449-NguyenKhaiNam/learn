package tree;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Integer> bst = new BST<>();
		bst.add(2);
		bst.add(1);
		bst.add(4);
		bst.add(3);
		bst.add(5);
		bst.add(9);
		bst.add(10);
		bst.add(8);

		// no.1
		System.out.println("No.1 " + bst.toString());

		// no.2
		bst.add(Arrays.asList(-2, -3, -1, -4, -5));
		System.out.println("No.2 " + bst.toString());

		// no.3
		System.out.println("No.3 " + bst.depth(-2));

		// no.4
		System.out.println("No.4 " + bst.height());

		// no.5
		System.out.println("No.5 " + bst.size());

		// no.6
		System.out.println("No.6 " + bst.contains(9));

		// no.7
		System.out.println("No.7 " + bst.findMin());

		// no.8
		System.out.println("No.8 " + bst.findMax());

		// no.9
		System.out.println("No.9 " + bst.remove(2));
		
		// no.10
		System.out.println("No.10 " + bst.descendants(-1).toString());

		// no.11
		System.out.println("No.11 " + bst.ancestors(9).toString());
	}

}
