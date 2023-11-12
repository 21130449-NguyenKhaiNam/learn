package BaiTap10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClassTestNumber {
	/*
	 * Cho mang so nguyen bat ky viet ham sap xep theo thu tu tu be toi lon va nguoc lai
	 * viet theo giai thuat va su dung list
	 */
	/*
	 * Su dung goi de nhap va lam
	 * Su dung vi neu nguoi dung nhap sai so thi cho chay lai
	 * Yeu cau nhap 1 la nho toi lon va 2 la lon toi nho 
	 * Phuong thuc lam nho toi lon hay lon toi nho thi lam rieng 
	 * Sau khi nhap dung so va da lam thi ngung while lai
	 */
	public static void sortAlgorithm(int[] arr) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Use sort algorithm");
		while(true) {
			System.out.println("Do you want " + "\"" + "big to small" + "\"" + " or" + "\"" + "small to big" + "\"");
			System.out.println("1 is small to big and 2 is big to small");
			switch (sc.nextInt()) {
			case 1:
				ClassTestNumber.smallToBigAlgorithm(arr);
				ClassTestNumber.printArray(arr);
				break;
			case 2:
				ClassTestNumber.bigToSmallAlgorithm(arr);
				ClassTestNumber.printArray(arr);
				break;
			default:
				System.out.println("Please check your enter number!");
				continue;
			}
			//Ngung khi da lam xong
			break;
		}
	}
	/*
	 * Thuc hien viec sap xep tu nho toi lon bang phuong thuc
	 */
	public static void smallToBigAlgorithm(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				int c;
				if(arr[i] < arr[j]) {
					c = arr[i];
					arr[i] = arr[j];
					arr[j] = c;
				}
			}
		}
	}
	/*
	 * Thuc hien viec sap xep tu lon toi nho bang phuong thuc
	 */
	public static void bigToSmallAlgorithm(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				int c;
				if(arr[i] > arr[j]) {
					c = arr[i];
					arr[i] = arr[j];
					arr[j] = c;
				}
			}
		}
	}
	/*
	 * Su dung goi de nhap va lam
	 * Su dung vi neu nguoi dung nhap sai so thi cho chay lai
	 * Yeu cau nhap 1 la nho toi lon va 2 la lon toi nho 
	 * Phuong thuc lam nho toi lon hay lon toi nho thi lam rieng 
	 * Sau khi nhap dung so va da lam thi ngung while lai
	 */
	public static void sortAPI(int[] arr) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Use sort API");
		while(true) {
			System.out.println("Do you want " + "\"" + "big to small" + "\"" + " or" + "\"" + "small to big" + "\"");
			System.out.println("1 is small to big and 2 is big to small");
			switch (sc.nextInt()) {
			case 1:
				ClassTestNumber.smallToBigAPI(arr);
				ClassTestNumber.printArray(arr);
				break;
			case 2:
				ClassTestNumber.bigToSmallAlgorithm(arr);
				ClassTestNumber.printArray(arr);
				break;
			default:
				System.out.println("Please check your enter number!");
				continue;
			}
			//Ngung khi da lam xong
			break;
		}
	}
	/*
	 * Su dung API tu be toi lon
	 * Tao ra danh sach list bo vao bien so nguyen su dung for de luu gia tri vao list
	 * Su dung api sap xep co trong ArrayList roi luu lai vao arr theo thu tu tu be toi lon roi goi ham in mang ra 
	 */
	public static void smallToBigAPI(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		Collections.sort(list);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}
	}
	/*
	 * Su dung API tu lon toi be
	 */
	public static void bigToSmallAPI(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		Collections.sort(list);
		int number = list.size()-1;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(number--);
		}
	}
	/*
	 * In ra khi da lam xong
	 */
	public static void printArray(int[] arr) {
		System.out.print("Array new is: [ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}
}
