package BaiTap3;

public class ClassTestNumber {
	/*
	 * Dem so chu so cua so bat ky
	 * bien count de dem so chu so, bien numberTest de luu so nguoi dung nhap khi lam viec se khong anh huong bien chinh, bien test de biet khi nao ket thuc vong lap
	 * Khi bien nhap la 0 thi co 1 so, truong hop rien biet
	 * Khac 0 thi thuc hien viec chia nguyen cho 10 cho toi khi bang 0 thi ngung lai
	 */
	public void countDigit(int number) {
		int count = 0;
		int numberTest = number;
		boolean test =  true;
		if(numberTest == 0) {
			System.out.println(number + " has 1 number");
		}
		if(number != 0) {
			while(test) {
				if(numberTest == 0) {
					test = false;
				}else {
					numberTest /= 10;
					count++;
				}
			}
			//So nhieu, so it
			if(count == 1) {
				System.out.println(number + " has " + count + " number");
			}else {
				System.out.println(number + " has " + count + " numbers ");
			}
		}
	}
}
