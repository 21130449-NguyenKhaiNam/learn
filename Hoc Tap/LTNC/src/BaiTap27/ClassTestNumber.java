package BaiTap27;

public class ClassTestNumber {
	/*
	 * Cho cac so <=100
	 */
	/*
	 * Co bao nhieu so chia het cho 5
	 * Cach biet bang tay: lay so lon nhat chia het cho no tru so be nhat chia het cho no chia cho no roi cong 1.
	 * Quy tac giai tay: trong khoang tu lon nhat toi be nhat chia het cho no thi khi chia no cu cach mot doan gap dung so chia het cho no
	 * nen thhuong chinh la so luong so chia het cong mot vi trong qua trinh di chia chua tinh thang lon nhat
	 * Giai may cho chay tu dau toi cuoi va dem
	 */
	public static void divisibleBy5() {
		int count = 0;
		for (int i = 0; i <= 100; i++) {
			if(i%5 == 0) {
				++count;
			}
		}
		System.out.println("Co " + count + " so chia het cho 5");
	}
	/*
	 * Chia het cho 5 du 1
	 * (so lon nhat chia cho no du 1 - so be nhat chia cho no du 1)/5 + 1
	 */
	public static void devisible5Remainder1() {
		int count = 0;
		for (int i = 0; i <= 100; i++) {
			if(i%5 == 1) {
				++count;
			}
		}
		System.out.println("Co " + count + " so chia het cho 5 du 1");
	}
	/*
	 * Chia 5 du 2
	 */
	public static void devisible5Remainder2() {
		int count = 0;
		for (int i = 0; i <= 100; i++) {
			if(i%5 == 2) {
				++count;
			}
		}
		System.out.println("Co " + count + " so chia het cho 5 du 2");
	}
	/*
	 *	Chia 5 du 3 
	 */
	public static void devisible5Remainder3() {
		int count = 0;
		for (int i = 0; i <= 100; i++) {
			if(i%5 == 3) {
				++count;
			}
		}
		System.out.println("Co " + count + " so chia het cho 5 du 3");
	}
	/*
	 *	Chia 5 du 4 
	 */
	public static void devisible5Remainder4() {
		int count = 0;
		for (int i = 0; i <= 100; i++) {
			if(i%5 == 4) {
				++count;
			}
		}
		System.out.println("Co " + count + " so chia het cho 5 du 4");
	}
}
