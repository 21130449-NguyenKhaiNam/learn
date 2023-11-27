package BaiTap30;

public class ClassTestNumber {
	/*
	 * A.
	 * Tinh tong
	 */
	public static void sum(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println("Sum 1  to " + n + " = " + sum);
	}
	/*
	 * B.
	 * Tinh gia thua
	 */
	public static void factorial(int n) {
		int count = 1;
		if(n > 0){
			for (int i = 1; i <= n; i++) {
				count *= i;
			}
			System.out.println(n + "! " + "= " + count);
		}else {
			System.out.println("Please check your number");
		}
	}
}
