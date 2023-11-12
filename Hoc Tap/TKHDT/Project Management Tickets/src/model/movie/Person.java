package model.movie;

public class Person {
	private String name;
	@SuppressWarnings("unused")
	private int age;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

}
