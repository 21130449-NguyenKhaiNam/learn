package ApplicationOfSearchingAlgorithms;

public class TestStudentsManagement {
	public static void main(String[] args) {
		Student[] students = { new Student("01", "Nam", 12, 3.5), new Student("02", "Minh", 9, 3.0),
				new Student("03", "Tu", 6, 3.7), new Student("04", "Ngan", 10, 4.0) };
		
		StudentManagement management = new StudentManagement(students);
		
		System.out.println(management.findSecondLargestGPAStudent().toString());
	}
}
