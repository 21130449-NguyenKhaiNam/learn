package task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class library {
	private String name;
	private List<book> books;

	/**
	 * @param name
	 * @param books
	 */
	public library(String name, List<book> books) {
		this.name = name;
		this.books = books == null ? new ArrayList<>() : books;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the books
	 */
	public List<book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "library [name=" + name + ", books=" + books + "]";
	}

	/**
	 * Quyen sach duoc xuat ban lau nhat
	 */
	public book getOldestBook() {
		return books.stream().min(book::rangeYear).get();
	}

	/**
	 * Tra ve danh sach cuon sach theo nam
	 */
	public Map<Integer, List<book>> getBooksByYears() {
		Map<Integer, List<book>> hashMap = new HashMap<>();
		books.stream().forEach(book -> book.addToMap(hashMap));
		return hashMap;
	}
	
	/**
	 * Tra ve cac quyen sach co cung nam xuat ban va tac gia cho truoc
	 */
	public Set<book> findBooks(String authorName, int year) {
		Set<book> treeSet = new TreeSet<>(book::rangeTitle);
		books.stream().forEach(book -> book.addToSet(treeSet, authorName, year));
		return treeSet;
	}
}
