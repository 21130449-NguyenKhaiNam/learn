package BaiTap12;

public class ClassTestNumber {
	/*
	 * Nhan vao ngay thang theo dinh dang dd/mm/yyyy tra ve theo dinh dang dd MM(dang chu) yyyy
	 * Chia chuoi thanh cac mang con 
	 * Phai kiem tra truoc vi ngay khong vuot qua 31 va thang khong qua 12 va ca hai phai lon hon 0
	 * Tao rieng ham tra ve thang bang chu cho gon
	 */
	public static void changeDateFormat(String date) {
		char[] d = date.toCharArray();
		String dd = d[0] + "" + d[1];
		String mm = d[3] + "" + d[4];
		String yyyy = d[6] + "" + d[7] + "" + d[8] + "" + d[9];
		if((Integer.parseInt(dd) <= 31)&&(Integer.parseInt(dd) <= 12)&&(Integer.parseInt(dd) > 0)&&(Integer.parseInt(dd) > 0)) {
			System.out.print(date + " change into ");
			System.out.print(dd + " ");
			ClassTestNumber.returnsTheMonthInLetters(mm);
			System.out.print(" " + yyyy);
		}else {
			System.out.println("Please check day or month!");
		}
	}
	
	/*
	 * Phuong thuc tra ve thang bang chu cai
	 */
	public static void returnsTheMonthInLetters(String month) {
		int monthNumber = Integer.parseInt(month);
		switch (monthNumber) {
		case 1 :  
			System.out.print("January");
			break;
		case 2 :
			System.out.print("February");
			break;
		case 3 :
			System.out.print("March");
			break;
		case 4 :
			System.out.print("April");
			break;
		case 5 :
			System.out.print("May");
			break;
		case 6:
			System.out.print("June");
			break;
		case 7 :
			System.out.print("July");
			break;
		case 8 :
			System.out.print("August");
			break;
		case 9 :
			System.out.print("Septemper");
			break;
		case 10 :
			System.out.print("October");
			break;
		case 11 :
			System.out.print("November");
			break;
		case 12 :
			System.out.print("December");
			break;
		}
	}
	
}
