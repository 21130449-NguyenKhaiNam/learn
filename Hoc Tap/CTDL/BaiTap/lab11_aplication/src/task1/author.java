package task1;

import java.util.Set;

public class author {
	private String name;
	private int birthYear;

	/**
	 * @param name
	 * @param birthYear
	 */
	public author(String name, int birthYear) {
		super();
		this.name = name;
		this.birthYear = birthYear;
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
	 * @return the birthYear
	 */
	public int getBirthYear() {
		return birthYear;
	}

	/**
	 * @param birthYear the birthYear to set
	 */
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	@Override
	public String toString() {
		return "author [name=" + name + ", birthYear=" + birthYear + "]";
	}

	public void addToSetIf(Set<book> treeSet,book b ,String authorName) {
		// TODO Auto-generated method stub
		if(name.equals(authorName))
			treeSet.add(b);
	}

}
