package task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Category {
	private List<Book> books;

	/**
	 * @param books
	 */
	public Category(List<Book> books) {
		super();
		this.books = books == null ? new ArrayList<>() : books;
	}

	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public double sumPrice() {
		return books.stream().map(Book::getPrice).reduce(0.0, Double::sum);
	}

	public Book maxPageChapter() {
		return books.stream().max(Book::pageChapterGreatherThan).get();
	}

	public boolean hasMagezine(String title) {
		return !books.stream().filter(book -> book.hasMagezine(title)).collect(Collectors.toList()).isEmpty();
	}

	public List<Book> magezineYearAgo(int yearAgo) {
		return books.stream().filter(b -> b.magezineYearAgo(yearAgo)).collect(Collectors.toList());
	}

	public Set<Book> sort(Comparator<Book> compare) {
		Set<Book> set = new TreeSet<>(compare);
		set.addAll(books);
		return set;
	}

	public Map<Integer, Integer> statisticsByYear() {
		return books.stream()
				.collect(Collectors.toMap(Book::getYear, value -> 1, (valueAfter, valueBefore) -> valueAfter + 1));
	}

}
