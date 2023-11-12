package task2;

public abstract class Book {
	private String title;
	private int page;
	private int year;
	private String author;
	private double price;

	/**
	 * @param title
	 * @param page
	 * @param year
	 * @param author
	 * @param price
	 */
	public Book(String title, int page, int year, String author, double price) {
		super();
		this.title = title;
		this.page = page;
		this.year = year;
		this.author = author;
		this.price = price;
	}

	@Override
	public String toString() {
		return "title=" + title + ", page=" + page + ", year=" + year + ", author=" + author + ", price=" + price;
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
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
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
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public abstract boolean isReference();

	public abstract String type();

	public abstract boolean oldMagezine(int yearAgo);

	public abstract boolean sameTypeAndAuthor(Book book);

	public abstract int pageChapterGreatherThan(Book that);

	public abstract boolean hasMagezine(String titleThat);

	public abstract boolean magezineYearAgo(int yearAgo);


}
