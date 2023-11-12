package BaiTap31;

import java.util.Scanner;

public class ClassTestNumber {
	/*
	 * Cho 2 so thuc x va e voi e la gia tri sai so rat nho
	 */
	/*
	 * Tinh giai thua cho cac ham sau su dung
	 * Neu bien bo vao la 0 thi tra ra 1 vi 0! = 1
	 * Neu lon hon 0 thi thuc hien lap theo giai thua  voi vong for cho toi khi i == n -1
	 * Cuoi cung in ra bien count vua lam, neu cos truong hop nao loi thi tra ra 0
	 */
	public static int factorial(int n) {
		int count = 1;
		for (int i = n; i > 0; i--) {
			count *= i;
		}
		return count;
	}
	/*
	 * Tinh e = 1 + 1/1! + 1/2! + ... + 1/n! toi khi 1/n! < e
	 * Nhan vao cac gia tri tu nguoi dung
	 * Thuc hien vong lap for voi bien i chay gia tri tu 0 toi n0 voi 1/no! < E, dieu kien i la khong vuot qua n
	 * Thuc hien tinh toan va luu vao bien e
	 * Neu dieu kien van chua be hon E thi lam tiep vong lap 
	 * Neu thoa be hon E thi cong tiep 1/n! tai do roi thoat ra 
	 */
	public static void maclaurinExpansionForE() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Calculation for the expression e = 1 + 1/1! + 1/2! + ... + 1/n! (Condition: 1/n! < E and 0 < E < 1)");
		System.out.print("Enter n:");
		int n = sc.nextInt();
		System.out.print("Enter E:");
		double E = sc.nextDouble();
		double e = 0;
		for (int i = 0; i<=n ; i++) {
			if((double)1/ClassTestNumber.factorial(i) > E) {
				e += (double)1/ClassTestNumber.factorial(i);
				continue;
			}else {
				e += (double)1/ClassTestNumber.factorial(i);
				break;
			}
			
		}
		System.out.println("e = " + e);
	}
	/*
	 * Tinh e^x = 1 + x/1! + x^2/2! + ... + (x^n)/n! toi khi (x^(n+1))/(n+1)! < E
	 * Nhan vao cac gia tri tu nguoi dung
	 * Thuc hien vong lap for voi bien i chay gia tri tu 0 toi n0 voi (x^(n0+1))/(n0+1)! < E, dieu kien i la khong vuot qua n
	 * Thuc hien tinh toan va luu vao bien e
	 * Neu dieu kien van chua be hon E thi lam tiep vong lap 
	 * Neu thoa be hon E thi cong tiep (x^n)/n! tai do roi thoat ra 
	 */
	public static void maclaurinExpansionForPowEX() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Calculation for the expression e^x = 1 + x/1! + x^2/2! + ... + (x^n)/n! (Condition: (x^(n+1))/(n+1)! < E and 0 < E < 1)");
		System.out.print("Enter n:");
		int n = sc.nextInt();
		System.out.print("Enter x:");
		double x = sc.nextDouble();
		System.out.print("Enter E:");
		double E = sc.nextDouble();
		double e = 0;
		for (int i = 0; i<=n ; i++) {
			if((double)Math.pow(x, i+1)/ClassTestNumber.factorial(i+1) > E) {
				e += (double)Math.pow(x, i)/ClassTestNumber.factorial(i);
				continue;
			}else {
				e += (double)Math.pow(x, i)/ClassTestNumber.factorial(i);
				break;
			}
			
		}
		System.out.println("e = " + e);
	}
	/*
	 * Tinh sin(x) = x - (x^3)/3! + (x^5)/5! - ... ((-1)^n)*(x^(2n+1))/(2n+1)! toi khi (x^(2n+1))/(2n+1)! < E
	 * Nhan vao cac gia tri tu nguoi dung
	 * Thuc hien vong lap for voi bien i chay gia tri tu 0 toi n0 voi (x^(2n+1))/(2n+1)! < E, dieu kien i la khong vuot qua n
	 * Thuc hien tinh toan va luu vao bien e
	 * Neu dieu kien van chua be hon E thi lam tiep vong lap 
	 * Neu thoa be hon E thi cong tiep ((-1)^n)*(x^(2n+1))/(2n+1)! tai do roi thoat ra 
	 */
	public static void maclaurinExpansionForSinX() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Calculation for the expression sin(x) = x - (x^3)/3! + (x^5)/5! - ... ((-1)^n)*(x^(2n+1))/(2n+1)! (Condition: (x^(2n+1))/(2n+1)! < E and 0 < E < 1)");
		System.out.print("Enter n:");
		int n = sc.nextInt();
		System.out.print("Enter x:");
		double x = sc.nextDouble();
		System.out.print("Enter E:");
		double E = sc.nextDouble();
		double sin = 0;
		for (int i = 0; i<=n ; i++) {
			if((double)Math.pow(x, 2*i+1)/ClassTestNumber.factorial(2*i+1) > E) {
				sin += (double)Math.pow(-1, i)*Math.pow(x, 2*i+1)/ClassTestNumber.factorial(2*i+1);
				continue;
			}else {
				sin += (double)Math.pow(-1, i)*Math.pow(x, 2*i+1)/ClassTestNumber.factorial(2*i+1);
				break;
			}
			
		}
		System.out.println("sin(x) = " + sin);
	}
}
