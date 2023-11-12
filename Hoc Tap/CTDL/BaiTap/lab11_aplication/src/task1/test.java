package task1;

import java.util.Arrays;

public class test {

	public static void say() {
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		author a_1 = new author("Nguyen Khai Nam", 2003);
		author a_2 = new author("Nguyen Khai Hoang", 1998);

		book b_1 = new book("01", "Sach A", 1000, "Kinh di", 1999, Arrays.asList(a_1, a_2));
		book b_2 = new book("02", "Sach B", 200, "Trinh tham", 1999, Arrays.asList(a_1, a_2));
		book b_3 = new book("03", "Sach C", 500, "Hai", 1997, Arrays.asList(a_1));

		library library = new library("Thu vien", Arrays.asList(b_1, b_2, b_3));

		System.out.println("Cau 1: " + library.getOldestBook().toString());
		System.out.println("Cau 2: " + library.getBooksByYears().toString());
		System.out.println("Cau 3: " + library.findBooks("Nguyen Khai Nam", 1999).toString());

	}

}
