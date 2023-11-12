package BaiTap14;

import java.util.Scanner;

public class ClassTestNumber {
	/*
	 * Cho hai so thuc x va n
	 */
	/*
	 * A.
	 * Tinh P = x^0 + x^1 + x^2 + ... + x^n
	 */
	public static void exponentiationAndAddition() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Calculate for the equation P = 1 + x + x^2 + x^3 + ... + x^n");
		System.out.print("Enter x:");
		int x = sc.nextInt();
		System.out.print("Enter n:");
		int n = sc.nextInt();
		int P = 0;
		for (int i = 0; i <= n; i++) {
			P += Math.pow(x, i);
		}
		System.out.println("P= " + P);
	}
	/*
	 * B.
	 * Tinh P = 1 – x + x^2 – x^3 + ... + x^n
	 */
	public static void exponentiationAndPlusHasSign() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Calculate for the equation P = 1 – x + x^2 – x^3 + ... + x^n");
		System.out.print("Enter x:");
		int x = sc.nextInt();
		System.out.print("Enter n:");
		int n = sc.nextInt();
		int P = 0;
		for (int i = 0; i <= n; i++) {
			P += Math.pow(-1, i)*Math.pow(x, i) ;
		}
		System.out.println("P= " + P);
	}
	/*
	 * C.
	 * Tinh P = 1 + x/1! x^2/2! + ... + x^n/n!
	 */
	public static void maclaurinExpansionForE() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Calculate for the equation P = 1 + x/1! x^2/2! + ... + x^n/n!");
		System.out.print("Enter x:");
		int x = sc.nextInt();
		System.out.print("Enter n:");
		int n = sc.nextInt();
		double P = 0;
		for (int i = 0; i <= n; i++) {
			P += (double)Math.pow(x, i)/ClassTestNumber.factorial(i) ;
		}
		System.out.println("P= " + P);
	}
	/*
	 * Tinh giai thua
	 */
	public static int factorial(int n) {
		int count = 1;
		if(n == 0) {
			return count;
		}else if(n > 0){
			for (int i = 0; i < n; i++) {
				count *= (n-i);
			}
			return count;
		}
		return 0;
	}
}
