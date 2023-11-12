package ApplicationOfSearchingAlgorithms;

public class Student {
	private String id;
	private String name;
	private int yob;// birth year
	private double gpa;

	/**
	 * @param id
	 * @param name
	 * @param yob
	 * @param gpa
	 */
	public Student(String id, String name, int yob, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.yob = yob;
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", yob=" + yob + ", gpa=" + gpa + "]";
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
	 * @return the yob
	 */
	public int getYob() {
		return yob;
	}

	/**
	 * @param yob the yob to set
	 */
	public void setYob(int yob) {
		this.yob = yob;
	}

	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

}
