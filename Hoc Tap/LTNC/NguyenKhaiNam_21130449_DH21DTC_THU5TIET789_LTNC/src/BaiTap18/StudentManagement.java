package BaiTap18;

import java.util.ArrayList;

public class StudentManagement {
	private ArrayList<Student> studentList = new ArrayList<Student>();

	public StudentManagement(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	/*
	 * In ra danh sach sinh vien
	 */
	public void print() {
		for (Student listStudent : studentList) {
			listStudent.printStudent();
			System.out.printf("%050d %n",0);
		}
	}
	
	/*
	 * Them sinh vien
	 * Su dung add co trong goi arraylist 
	 */
	public void addStudent(Student st) {
		studentList.add(st);
	}
	
	/*
	 * Thay doi diem cho sinh vien
	 */
	public void addScore(int idStudent, Subject addScore) {
		for (Student listStudent: studentList) {
			if(listStudent.getIdStudent() == idStudent) {
				listStudent.addScore(addScore);
				return;
			}
		}
	}
	
	/*
	 * Tinh diem trung binh 
	 */
	public void averageScore(int idStudent) {
		for (Student listStudent: studentList) {
			if(listStudent.getIdStudent() == idStudent) {
				System.out.println("Average of " + listStudent.getNameStudent() + " is: " + listStudent.averageScore());
				return;
			}
		}
	}
	
	/*
	 * In danh sach sap xep theo ten, theo diem
	 * Ten theo bang chu cai, diem theo thu tu giam dan
	 * Lay ten ra neu giong thi ca ho ten giong nua thi lay diem
	 */
	public void sortList() {
		for (int i = 0; i < studentList.size(); i++) {
			for (int j = i; j < studentList.size(); j++) {
				int count = studentList.get(i).getFirstName().compareTo(studentList.get(j).getFirstName());
				if(count > 0) {
					convert(i, j);
				}else if(count == 0) {
					count = studentList.get(i).getNameStudent().compareTo(studentList.get(j).getNameStudent());
					if(count > 0) {
						convert(i, j);
						continue;
					}else if(studentList.get(i).compareAverage(studentList.get(j))) {
						convert(i, j);
					}
				}
			}
		}
	}
	
	/*
	 * Nhan vao vi tri can hoan doi voi nhau trong student list, thuc hien hoan doi
	 */
	public void convert(int thisInStudentList, int thatInStudentList) {
		Student temp = studentList.get(thisInStudentList);
		studentList.set(thisInStudentList, studentList.get(thatInStudentList));
		studentList.set(thatInStudentList, temp);
	}
	
	/*
	 * Tim sinh vien
	 */
	public void findStudent(int idStudent) {
		for (Student listStudent : studentList) {
			if(listStudent.getIdStudent() == idStudent) {
				listStudent.printStudent();
				return;
			}
		}
	}
}
