package BaiTap26;

import java.util.Scanner;

public class ClassTestNumber {
	/*
	 * Viet chuong trinh yeu cau nhap vao so nguyen cho toi khi nguoi dung nhap 0 thi ngung va in ra trung binh cac so da nhap
	 */
	public static void gameEnterNumber() {
		double count = 0;
		int a = 0;
		int b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to a game number!");
		do {
			System.out.println("Enter an interger:");
			b = sc.nextInt();
			count = count + b;
			++a;
		} while (b != 0);
		System.out.println("This is the average of your numbers: " + (count/a));
	}
}
