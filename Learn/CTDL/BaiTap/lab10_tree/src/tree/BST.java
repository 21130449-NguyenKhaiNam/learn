package tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	@Override
	public String toString() {
		return "BST [root=" + root + "]";
	}

	// display BST using inorder approach
	public void inorder() {
		// TODO
		if(isNull())
			System.out.println(root);
		root.inorder();
	}

	// display BST using preorder approach
	public void preorder() {
		// TODO
		if(isNull())
			System.out.println(root);
		root.preorder();
	}

	// display BST using postorder approach
	public void postorder() {
		// TODO
		if(isNull())
			System.out.println(root);
		root.postorder();
	}

	/**
	 * @return the root
	 */
	public BNode<E> getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(BNode<E> root) {
		this.root = root;
	}

	public boolean isNull() {
		return root == null;
	}

	public boolean isNull(E e) {
		return e == null;
	}

	// Add element e into BST
	public void add(E e) {
		// TODO
		if (!isNull(e)) {
			if (isNull()) {
				root = new BNode<E>(e);
			} else {
				root.add(e);
			}
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		// TODO
		if (!col.isEmpty()) {
			Iterator<E> itr = col.iterator();
			if (isNull())
				root = new BNode<E>(itr.next());
			while (itr.hasNext())
				root.add(itr.next());
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		// TODO
		if (isNull() || isNull(node))
			return -1;
		return root.depth(node, 0);
	}

	// compute the height of BST
	public int height() {
		// TODO
		if (isNull())
			return -1;
		return root.height();
	}

	// Compute total nodes in BST
	public int size() {
		// TODO
		if (isNull())
			return -1;
		return root.size();
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		// TODO
		if (isNull() || isNull(e))
			return false;
		return root.contains(e);
	}

	// Find the minimum element in BST
	public E findMin() {
		// TODO
		if (isNull())
			return null;
		return root.findMin();
	}

	// Find the maximum element in BST
	public E findMax() {
		// TODO
		if (isNull())
			return null;
		return root.findMax();
	}

	// Remove element e from BST
	public boolean remove(E e) {
		// TODO
		if (isNull() || isNull(e))
			return false;
		return root.remove(e);
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		// TODO
		List<E> list = new ArrayList<>();
		if (isNull() || isNull(data))
			return list;
		return root.descendants(data, list);
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		// TODO
		List<E> list = new ArrayList<>();
		if (isNull() || isNull(data))
			return list;
		return root.ancestors(data, list);
	}

}
