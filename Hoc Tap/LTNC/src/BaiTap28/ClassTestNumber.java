package BaiTap28;

import java.util.Scanner;

public class ClassTestNumber {
	/*
	 * Tinh nghiem phuong trinh bac hai
	 */
	public static void quadratic() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao cac tri so: ");
		char[] arr1 = {'a','b','c'};
		double[] arr2 = new double[3];
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " = ");
			arr2[i] = sc.nextDouble();
		}
		if(arr2[0] != 0) {
			//
			ClassTestNumber.testDelta(arr2[0], arr2[1], arr2[2]);
		}else {
			System.out.println("Please check a!");
		}
	}
	/*
	 * 
	 */
	public static void testDelta(double a, double b, double c) {
		double delta = b*b - 4*a*c;
		if(delta > 0) {
			System.out.println("The equation has two solutions");
			ClassTestNumber.solutions(a, b, delta);
		}else if(delta < 0 ) {
			System.out.println("the equation has no solutions");
		}else {	
			System.out.println("The equation has one solutions");
			System.out.println("Solution: " + (-b/2*a));
		}
	}
	/*
	 * 
	 */
	public static void solutions(double a, double b, double delta) {
		System.out.println("First solution: " + ((-b + Math.sqrt(delta))/2*a));
		System.out.println("Second solution: " + ((-b - Math.sqrt(delta))/2*a));
	}
}
