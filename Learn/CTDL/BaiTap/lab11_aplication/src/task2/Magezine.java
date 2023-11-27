package task2;

import java.util.Calendar;

public class Magezine extends Book {

	public Magezine(String title, int page, int year, String author, double price) {
		super(title, page, year, author, price);
		// TODO Auto-generated constructor stub
	}
	
	public int rangeYear() {
		return Calendar.getInstance().get(Calendar.YEAR) - this.getYear();
	}

	@Override
	public String toString() {
		return "Magezine [" + super.toString() + "]";
	}

	@Override
	public boolean isReference() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "Magezine";
	}

	@Override
	public boolean oldMagezine(int yearAgo) {
		// TODO Auto-generated method stub
		return rangeYear() >= yearAgo;
	}

	@Override
	public boolean sameTypeAndAuthor(Book book) {
		// TODO Auto-generated method stub
		return !book.isReference() && this.getAuthor().equals(book.getAuthor());
	}

	@Override
	public int pageChapterGreatherThan(Book that) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasMagezine(String titleThat) {
		// TODO Auto-generated method stub
		return this.getTitle().equals(titleThat);
	}

	@Override
	public boolean magezineYearAgo(int yearAgo) {
		// TODO Auto-generated method stub
		return rangeYear() == yearAgo;
	}

}
