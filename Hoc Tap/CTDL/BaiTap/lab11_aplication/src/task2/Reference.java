package task2;

import java.util.List;

public class Reference extends Book {
	private String field;
	private List<Chapter> chapters;

	/**
	 * @param title
	 * @param page
	 * @param year
	 * @param author
	 * @param price
	 * @param field
	 */
	public Reference(String title, int year, String author, double price, String field, List<Chapter> chapters) {
		super(title, 0, year, author, price);
		this.field = field;
		this.chapters = chapters;
		setPage();
	}

	@Override
	public String toString() {
		return "Reference [" + super.toString() + " field=" + field + "]";
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the chapters
	 */
	public List<Chapter> getChapters() {
		return chapters;
	}

	/**
	 * @param chapters the chapters to set
	 */
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	public void setPage() {
		int sum = 0;
		for (Chapter chapter : chapters)
			sum += chapter.getPage();
		setPage(sum);
	}

	@Override
	public boolean isReference() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "Reference";
	}

	@Override
	public boolean oldMagezine(int yearAgo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sameTypeAndAuthor(Book book) {
		// TODO Auto-generated method stub
		return book.isReference() && this.getAuthor().equals(book.getAuthor());
	}

	@Override
	public int pageChapterGreatherThan(Book that) {
		// TODO Auto-generated method stub
		Chapter maxPageThis = chapters.stream().max(Chapter::pageGreatherThan).get();
		if (!that.isReference())
			return maxPageThis.getPage();
		Reference re = (Reference) that;
		return maxPageThis.pageGreatherThan(re.chapters.stream().max(Chapter::pageGreatherThan).get());
	}

	@Override
	public boolean hasMagezine(String titleThat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean magezineYearAgo(int yearThat) {
		// TODO Auto-generated method stub
		return false;
	}
}
