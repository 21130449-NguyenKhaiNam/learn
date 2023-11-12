package BaiTap18;

import java.util.ArrayList;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dateNam = new Date(12,10,2003);
		Date dateTrinh = new Date(30,8,2003);
		Date dateNhan = new Date(28,11,2003);
		Date dateNgan = new Date(23,11,2003);
		Date dateVy = new Date(9,3,2003);
		
		Subject sjToan = new Subject("Toan", "T000", 10);
		Subject sjVan = new Subject("Van", "V000", 5);
		Subject sjHoa = new Subject("Hoa", "H000", 7);
		Subject sjTin = new Subject("Tin", "T001", 9);
		Subject sjVL = new Subject("Vat Ly", "V001", 7);
		Subject sjDL = new Subject("Dia Ly", "D000", 4);
		Subject sjSu = new Subject("Su", "S000", 2);
		Subject sjGDCD = new Subject("GDCD", "G000", 5);
		Subject sjTD = new Subject("The Duc", "T002", 1);
		Subject sjTA = new Subject("Tieng Anh", "T003", 8);
		
		ArrayList<Subject> subjectListNam = new ArrayList<Subject>();
		subjectListNam.add(sjToan);
		subjectListNam.add(sjVL);
		ArrayList<Subject> subjectListTrinh = new ArrayList<Subject>();
		subjectListTrinh.add(sjVan);
		subjectListTrinh.add(sjHoa);
		ArrayList<Subject> subjectListNhan = new ArrayList<Subject>();
		subjectListNhan.add(sjTin);
		subjectListNhan.add(sjDL);
		ArrayList<Subject> subjectListNgan = new ArrayList<Subject>();
		subjectListNgan.add(sjSu);
		subjectListNgan.add(sjGDCD);
		ArrayList<Subject> subjectListVy = new ArrayList<Subject>();
		subjectListVy.add(sjTD);
		subjectListVy.add(sjTA);
		
		Student Nam = new Student("Nguyen Khai Nam", 21130449, dateNam, subjectListNam);
		Student Trinh = new Student("Tran Mai Trinh", 23576189, dateTrinh, subjectListTrinh);
		Student Nhan = new Student("Le Vinh Nhan", 21130549, dateNhan, subjectListNhan);
		Student Ngan = new Student("Nguyen Thi Kim Ngan", 21130448, dateNgan, subjectListNgan);
		Student Vy = new Student("Dang Cat Tuong Vy", 21145160, dateVy, subjectListVy);
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(Nam);
		studentList.add(Trinh);
		studentList.add(Nhan);
		studentList.add(Ngan);
		studentList.add(Vy);
		
		StudentManagement st = new StudentManagement(studentList);
		
		/*
		 * Them hoc sinh
		 */
		Date dateNamN = new Date(23, 9, 2002);
		Subject sjKNGT = new Subject("Ky Nang Giao Tiep", "K000", 10);
		Subject sjKNM = new Subject("Ky Nang Men", "K001", 10);
		ArrayList<Subject> subjectListNamN = new ArrayList<Subject>();
		subjectListNamN.add(sjKNM);
		subjectListNamN.add(sjKNGT);
		Student NamN = new Student("Nguyen Khai Nam", 2116589, dateNamN, subjectListNamN);
		st.addStudent(NamN);
		
		/*
		 * Them diem 
		 */
		Subject sjKNGT2 = new Subject("Ky Nang Giao Tiep", "K000", 8.5);
		Subject sjKTCT = new Subject("Kinh Te Chinh Tri", "K003", 8.5);
		st.addScore(2116589, sjKTCT);
		st.addScore(2116589, sjKNGT2);
		
		/*
		 * Tinh diem trung binh
		 */
		st.averageScore(21130449);
		System.out.println();
		
		/*
		 * Sap xep theo ten, diem
		 */
		st.sortList();
		st.print();
		
		/*
		 * Tim sinh vien
		 */
		st.findStudent(21130446);
		
	}
}
