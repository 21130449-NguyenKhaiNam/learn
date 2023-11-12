package BaiTap29;

public class ClassTestNumber {
	/*
	 * Tinh gia thua
	 */
	public static void factorial(int n) {
		int count = 1;
		if(n >= 0) {
			for (int i = n; i > 0; i--) {
				count *= i;
			}
			System.out.println(n + "! " + "= " + count);
		}else {
			System.out.println("Please check your number");
		}
	}
}
