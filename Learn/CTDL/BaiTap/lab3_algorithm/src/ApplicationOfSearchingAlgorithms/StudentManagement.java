package ApplicationOfSearchingAlgorithms;

import java.util.Arrays;

public class StudentManagement {
	private Student[] students;
	
	/**
	 * @param students
	 */
	public StudentManagement(Student[] students) {
		this.students = students;
	}

	// find the student based on the given id using binary search
	public Student findStudent(String id) {
		// TODO
		int left = 0;
		int right = students.length - 1;
		int mid = 0;
		while (left != right) {
			mid = (left + right) / 2;
			String string_temp = students[mid].getId();
			if (id.equals(string_temp))
				return students[mid];
			if (id.compareTo(string_temp) < 0)
				right = mid - 1;
			if (id.compareTo(string_temp) > 0)
				left = mid + 1;
		}
		return id.equals(students[mid].getId()) ? students[mid] : null;
	}

	public Student[] findByYoB(int yob) {
		// TODO
		int countYoB = countYoB(yob);
		Student[] students_new = new Student[countYoB];
		// FSN: for student new
		int indexFSN = 0;
		for (Student student : students_new) {
			if (student.getYob() == yob)
				students_new[indexFSN] = student;
		}
		return students_new;
	}

	private int countYoB(int yob) {
		// TODO Auto-generated method stub
		int count = 0;
		for (Student student : students) {
			if (student.getYob() == yob)
				++count;
		}
		return count;
	}

	public Student findSecondLargestGPAStudent() {
		// TODO
		if(students.length <= 1)
			return null;
		Student[] students_new = students.clone();
		students_new = sortStudent(students_new);
		return students_new[students_new.length - 2];
	}

	private Student[] sortStudent(Student[] students_new) {
		// TODO Auto-generated method stub
		for (int i = 0; i < students_new.length - 1; i++) {
			int index = minGPA(students_new, i + 1);
			if (students_new[i].getGpa() > students_new[index].getGpa()) {
				Student student = students_new[i];
				students_new[i] = students_new[index];
				students_new[index] = student;
			}
		}
		return students_new;
	}
	
	private static int minGPA(Student[] students_new, int start) {
		Student student = students_new[start];
		int index = start;
		for (int i = start + 1; i < students_new.length; i++) {
			Student student_temp = students_new[i];
			if (student_temp.getGpa() < student.getGpa()) {
				student = student_temp;
				index = i;
			}
		}
		return index;
	}
}
