package BaiTap16;

import java.util.Arrays;

public class ClassTestNumber {

	/*
	 * Cho mang so nguyen bat ky tim gia tri lon nhat be nhat vi tri dau tien co
	 * phan tu lon nhat tong gia tri lon nhat
	 */
	public void giaTriLonNhatNhoNhat(int[] arr, boolean test) {
		// test == true; lon nhat
		// test == false; nho nhat
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			max = Math.max(max, Math.max(arr[i], arr[i + 1]));
			min = Math.min(min, Math.min(arr[i], arr[i + 1]));
		}
		if (test) {
			System.out.println("Gia tri lon nhat la " + max);
		} else {
			System.out.println("Gia tri nho nhat la " + min);
		}
	}

	public void viTriCoPhanTuLonNhatDauTien(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			max = Math.max(max, Math.max(arr[i], arr[i + 1]));
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max) {
				System.out.println("Vi tri dau lon nhat la " + i + " so do la " + arr[i]);
				break;
			}
		}
	}

	public void tongGiaTriLonNhat(int[] arr) {
		int max = 0;
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			max = Math.max(max, Math.max(arr[i], arr[i + 1]));
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max) {
				sum += arr[i];
			}
		}
		System.out.println("Tong gia tri la " + sum);
	}
}
