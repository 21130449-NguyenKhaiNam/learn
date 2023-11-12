package BaiTap7;

import java.util.Random;
import java.util.Scanner;

public class ClassTestNumber {
	/*
	 * Viet tro choi doan so, chuong trinh chay ngau nhien so tu 1 toi 100, sau do cho nguoi dung nhap vao mot so roi may se bao lon hon hay nho hon sau do toi khi dung bao so lan da nhap cua nguoi dung
	 * Bien count de dem so lan nguoi choi da nhap, Scanner la class nhan gia tri nhap, Random la lop chay so ngau nhien
	 * Cho chay vong lap toi khi nao nguoi dung doan dung so thi ngung
	 * Ban dau moi nguoi dung nhap so
	 * Chay vong lap kiem tra roi in ra cau theo tuy dieu kien
	 * Su dung continue de chuong trinh chay nhanh hon khi dung dieu kien thi thoat ra tao vong lap moi ma khong can kiem cac cai duoi
	 * break la de thoat ra khi da doan dung
	 */
	public static void gameNumber() {
		int count = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Random randomNumber = new Random();
		int number = randomNumber.nextInt(100);
		System.out.println("Chao mung den tro choi quay so!!!" + "\n" + "So da duoc tao ngau nhien tu 1 toi 100");
		while(true) {
			System.out.println("Nhap vao so ban doan:");
			int yourNumber = sc.nextInt();
			if(yourNumber < number) {
				System.out.println("So ban be hon roi!");
				++count;
				continue;
			}else if(yourNumber > number) {
				System.out.println("So ban lon hon roi!");
				++count;
				continue;
			}else {
				System.out.println("Chuc mung nha ><");
				System.out.println("So lan ban da doan la: " + count);
				break;
			}
		}
	}
}
