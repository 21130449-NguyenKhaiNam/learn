package student;

//doubly linked node
public class Node<E> {
	private E data;
	private Node<E> prev;
	private Node<E> next;

	public Node(E data) {
		this.data = data;
	}

	public Node(E data, Node<E> prev, Node<E> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
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
	 * @return the prev
	 */
	public Node<E> getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}

	/**
	 * @return the next
	 */
	public Node<E> getNext() {
		return next;
	}
	
	
}
