package BaiTap6;

import java.util.Random;
import java.util.Scanner;

public class ClassTestNumber {
	/*
	 * Hien thi len console mang hai chieu bat ky
	 * Class random tao so ngau nhien, class scanner nhan gia tri nhap
	 * Yeu cau nguoi dung nhap vao gioi han so mong muon, khong qua lon
	 * Mang khi yeu cau do dai se cho ra so dong, su dung mang[].length va nhap gia tri dong se cho ra so cot
	 */
	public void printMatrix(int[][] matrix) {
		Random randomNumber = new Random();
		System.out.println("Enter number limit: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println("A Random matrix is:");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = randomNumber.nextInt(number);
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	/*
	 * Tao ra ma tran so nguyen hai chieu the hien tam giac pascal 
	 * Tao ra mang de the hien tam giac
	 * Cho so bat dau la do nguoi dung nhap
	 * Dong tuy y nhung o vi tri cot 1 thi luon bang so bat dau
	 * so dong tang len thi so cot co so cung tang voi cong thuc la con so o dong truoc no o cot truoc no cong them 1 don vi
	 * Khi ket thuc lam viec voi cot thi phai co cai ngan cach 
	 */
	public void createPascalTriangle(int size) {
		int[][] matrix = new int[size][size];
		System.out.println("Enter a number start:");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		//So bat dau ban dau 
		matrix[0][0] = sc.nextInt();
		System.out.println("Matrix your enter is: ");
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = matrix[0][0];
			System.out.print(matrix[i][0]);
			for (int j = 1; j <= i; j++) {
				matrix[i][j] = matrix[i-1][j-1] + 1;
				System.out.print("\t" + matrix[i][j]);
			}
			System.out.println();
		}
	}
	/*
	 * Nhan vao mang so nguyen bat ky, sau do viet tam giac voi duong cheo la mang so nguyen do va co so dong bang so phan tu cua mang so, cot ben trai se bang cot ben phai tru 1
	 * tao mang hai chieu co do dai va rong bang kich thuoc cua mang tao ra
	 * lay chuoi lam canh huyen tam giac thi bat dau luu so do o vi tri cuoi cung chuoi, ben phai cang xa canh huyen tru cang lon theo quy tac no tru cho vi tri cot va cong cho vi tri dong
	 */
	public int[][] createPascalTriangle(int[] diagonalValues){
		int[][] createPascalTriangle = new int[diagonalValues.length][diagonalValues.length];
		for (int i = 0; i < diagonalValues.length; i++) {
			for (int j = 0; j<=i; j++) {
				createPascalTriangle[i][j] = diagonalValues[i] - (i - j);
			}
		}
		return createPascalTriangle;
	}
}

 



















