package BaiTap18;

import java.util.ArrayList;

public class Student {
	private String nameStudent;
	private int idStudent;
	private Date date;
	private ArrayList<Subject> subjectList = new ArrayList<Subject>();
	
	public Student(String nameStudent, int idStudent, Date date, ArrayList<Subject> subjectList) {
		this.nameStudent = nameStudent;
		this.idStudent = idStudent;
		this.date = date;
		this.subjectList = subjectList;
	}
	/*
	 * In ra thong tin sinh vien
	 */
	public void printStudent() {
		System.out.println("Name: " + nameStudent + "\t\t" + "ID student: " + idStudent);
		System.out.println();
		System.out.println("Average: " + this.averageScore());
	}
	
	/*
	 * Lay ten 
	 */
	public String getNameStudent() {
		return nameStudent;
	}
	
	/*
	 * Lay id student
	 */
	public int getIdStudent() {
		return idStudent;
	}
	
	/*
	 * Thay doi diem cho vao mon hoc cho sinh vien, neu chua co thi tao mon hoc do
	 */
	public void addScore(Subject addScore) {
		for (Subject listSubject : subjectList) {
			if(listSubject.getNameSubject().equalsIgnoreCase(addScore.getNameSubject()) && listSubject.getIdSubject().equals(addScore.getIdSubject())) {
				listSubject.addScore(addScore.getScore());
				return;
			}
		}
		subjectList.add(addScore);
	}
	
	/*
	 * Tinh diem trung binh
	 */
	public double averageScore() {
		double count = 0;
		for (Subject listSubject : subjectList) {
			count += listSubject.getScore();
		}
		return count/subjectList.size();
	}
	
	/*
	 * Diem thap hon thi moi hoan doi ben StudentManagement
	 */
	public boolean compareAverage(Student that) {
		if(this.averageScore() < that.averageScore()) {
			return true;
		}
		return false;
	}
	
	/*
	 * Chi lay ten ra
	 */
	public String getFirstName() {
		return nameStudent.substring(nameStudent.lastIndexOf(" ")+1);
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
