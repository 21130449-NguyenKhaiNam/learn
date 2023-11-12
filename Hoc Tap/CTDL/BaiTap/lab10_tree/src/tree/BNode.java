package tree;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "BNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public BNode<E> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public BNode<E> getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BNode<E> right) {
		this.right = right;
	}

	// Is null
	public boolean isNull(BNode<E> node) {
		return node == null;
	}

	// E is null
	public boolean isNull(E e) {
		return e == null;
	}

	// Is leaf
	public boolean isLeaf() {
		return isNull(left) && isNull(right);
	}

	private List<E> toList() {
		// TODO Auto-generated method stub
		List<E> list = new ArrayList<>();
		if (isNull(data))
			return list;
		List<E> empty = new ArrayList<>();
		list.add(data);
		list.addAll(isNull(left) ? empty : left.toList());
		list.addAll(isNull(right) ? empty : right.toList());
		return list;
	}

	public void add(E e) {
		// TODO Auto-generated method stub
		if (isNull(data))
			data = e;
		int minus = e.compareTo(data);
		if (minus < 0) {
			if (isNull(left)) {
				left = new BNode<E>(e);
			} else {
				left.add(e);
			}
		} else if (minus > 0) {
			if (isNull(right)) {
				right = new BNode<E>(e);
			} else {
				right.add(e);
			}
		}
	}

	public int depth(E node, int sum) {
		// TODO Auto-generated method stub
		if (isNull(data))
			return -1;
		int minus = node.compareTo(data);
		return minus == 0 ? sum
				: (minus < 0 ? (isNull(left) ? -1 : left.depth(node, ++sum))
						: (isNull(right) ? -1 : right.depth(node, ++sum)));
	}

	public int height() {
		// TODO Auto-generated method stub
		return isLeaf() ? 0
				: (1 + (!(isNull(left) || isNull(right)) ? Math.max(left.height(), right.height())
						: (isNull(left) ? right.height() : left.height())));
	}

	public int size() {
		// TODO Auto-generated method stub
		return 1 + (isLeaf() ? 0
				: (isNull(left) ? right.size() : (isNull(right) ? left.size() : left.size() + right.size())));
	}

	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return depth(e, 0) != -1;
	}

	public E findMin() {
		// TODO Auto-generated method stub
		return isNull(left) ? data : left.findMin();
	}

	public E findMax() {
		// TODO Auto-generated method stub
		return isNull(right) ? data : right.findMax();
	}

	public boolean remove(E e) {
		// TODO Auto-generated method stub
		if (isNull(data))
			return false;
		int minus = e.compareTo(data);
		if (minus == 0) {
			if (isLeaf()) {
				data = null;
			} else if (isNull(left)) {
				data = right.findMin();
				right.remove(data);
			} else {
				data = left.findMax();
				left.remove(data);
			}
			return true;
		}
		return minus < 0 ? (isNull(left) ? false : left.remove(e)) : (isNull(right) ? false : right.remove(e));
	}

	public List<E> descendants(E e, List<E> list) {
		// TODO Auto-generated method stub
		if (isNull(data))
			return list;
		int minus = e.compareTo(data);
		if (minus == 0) {
			list.addAll(this.toList());
			list.remove(0);
			return list;
		}
		return minus < 0 ? (isNull(left) ? list : left.descendants(e, list))
				: (isNull(right) ? list : right.descendants(e, list));
	}

	public List<E> ancestors(E e, List<E> list) {
		// TODO Auto-generated method stub
		if (isNull(data))
			return list;
		int minus = e.compareTo(data);
		List<E> empty = new ArrayList<>();
		if (minus == 0)
			return list;
		list.add(data);
		return minus < 0 ? (isNull(left) ? empty : left.ancestors(e, list))
				: (isNull(right) ? empty : right.ancestors(e, list));
	}

	public void inorder() {
		// TODO Auto-generated method stub
		if (!isNull(left))
			left.inorder();
		System.out.print(data + " ");
		if (!isNull(right))
			right.inorder();
	}

	public void preorder() {
		// TODO Auto-generated method stub
		System.out.print(data + " ");
		if (!isNull(left))
			left.preorder();
		if (!isNull(right))
			right.preorder();
	}

	public void postorder() {
		// TODO Auto-generated method stub
		if (!isNull(left))
			left.postorder();
		if (!isNull(right))
			right.postorder();
		System.out.print(data + " ");
	}

}
