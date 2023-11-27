package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class book {
	private String id;
	private String title;
	private int price;
	private String type;
	private int year;
	private List<author> authors;

	/**
	 * @param id
	 * @param title
	 * @param price
	 * @param type
	 * @param year
	 * @param authors
	 */
	public book(String id, String title, int price, String type, int year, List<author> authors) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.type = type;
		this.year = year;
		this.authors = authors;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		book other = (book) obj;
		return Objects.equals(authors, other.authors) && Objects.equals(id, other.id) && price == other.price
				&& Objects.equals(title, other.title) && Objects.equals(type, other.type) && year == other.year;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the authors
	 */
	public List<author> getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "book [id=" + id + ", title=" + title + ", price=" + price + ", type=" + type + ", year=" + year
				+ ", authors=" + authors + "]";
	}

	public int rangeYear(book b) {
		// TODO Auto-generated method stub
		return year - b.year;
	}

	public void addToMap(Map<Integer, List<book>> hashMap) {
		// TODO Auto-generated method stub
		if (!hashMap.containsKey(year))
			hashMap.put(year, new ArrayList<book>());
		hashMap.get(year).add(this);
	}

	public int rangeTitle(book t) {
		// TODO Auto-generated method stub
		return title.compareTo(t.title);
	}

	public void addToSet(Set<book> treeSet, String authorName, int yearThat) {
		// TODO Auto-generated method stub
		if (!authorName.isBlank() && yearThat > 1 && yearThat == year)
			authors.stream().forEach(author -> author.addToSetIf(treeSet, this, authorName));
	}
}
