package student;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	public static final float LOAD_FACTOR = 0.75f;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// Update length when size > elements.length * 75%;
	public void updateLength() {
		if (size > elements.length * LOAD_FACTOR) {
			E[] elements_temp = elements.clone();
			elements = (E[]) new Object[(int) (elements.length + DEFAULT_CAPACITY * 0.5)];
			System.arraycopy(elements_temp, 0, elements, 0, size);
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		return elements[i];
	}

	// Replaces the element at index i with e, and returns the replaced element.
	public E set(int i, E e) throws IndexOutOfBoundsException {
		elements[i] = e;
		return e;
	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		updateLength();
		elements[size] = e;
		++size;
		return false;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.

	public void add(int i, E e) throws IndexOutOfBoundsException {
		updateLength();
		if (i < size) {
			E temp_1 = elements[i];
			elements[i] = e;
			for (int j = i + 1; j <= size; j++) {
				E temp_2 = elements[j];
				elements[j] = temp_1;
				temp_1 = temp_2;
			}
			++size;
		}
	}

	// Removes/returns the element at index i, shifting subsequent elements earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < size) {
			updateLength();
			E element_remove = elements[i];
			for (int j = i; j < size; j++)
				elements[j] = elements[j + 1];
			--size;
			return element_remove;
		}
		return null;
	}

	public String toString() {
		String toString = "MyArrayList = [";
		for (int i = 0; i < size - 1; i++)
			toString += elements[i].toString() + ", ";
		return toString + elements[size - 1].toString() + "]";
	}
}
