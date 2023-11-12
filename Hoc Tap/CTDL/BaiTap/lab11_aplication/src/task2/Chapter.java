package task2;

public class Chapter {
	private String title;
	private int page;

	/**
	 * @param title
	 * @param page
	 */
	public Chapter(String title, int page) {
		super();
		this.title = title;
		this.page = page;
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

	public int pageGreatherThan(Chapter that) {
		// TODO Auto-generated method stub
		return page - that.page;
	}

}
