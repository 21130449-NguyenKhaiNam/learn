package student;

//Doubly Linked List
public class MyLinkedList<E> {
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	public MyLinkedList() {
		header = new Node<>(null, null, null); // create header
		trailer = new Node<>(null, header, null); // trailer is preceded by header
		header.setNext(trailer); // header is followed by trailer
	}

	// Returns the number of elements in the list.
	public int size() {
		return size;
	}

	// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the first element in the list.
	public E first() {
		return header.getData();
	}

	// Returns (but does not remove) the last element in the list.
	public E last() {
		return trailer.getData();
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		if (header.getData() == null) {
			header.setData(e);
		} else {
			header.setPrev(new Node<E>(e, null, header));
			header = header.getPrev();
		}
		++size;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		if (trailer.getData() == null) {
			trailer.setData(e);
		} else {
			trailer.setNext(new Node<E>(e, trailer, null));
			trailer = trailer.getNext();
		}
		++size;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		E e = header.getData();
		header = header.getNext();
		header.setPrev(null);
		--size;
		return e;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		E e = trailer.getData();
		trailer = trailer.getPrev();
		trailer.setNext(null);
		--size;
		return e;
	}

	public String toString() {
		String toString = "MyLinkedList = [";
		return (size == 0 ? toString : str(toString, header, header.getNext())) + "]";
	}

	private String str(String toString, Node<E> node, Node<E> next) {
		if (next == null || (next.getNext() == null && next.getData() == null))
			return toString + node.getData();
		if (node.getData() == null)
			return str(toString, next, next.getNext());
		return str(toString + node.getData() + ", ", next, next.getNext());

	}

}
