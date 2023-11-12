package BaiTap11;

import java.util.Random;

public class ClassTestNumber {
	/*
	 * Cho vao hai thu: mang so nguyen va mot so nguyen bat ky. Biet so nguyen be hon so luong mang so
	 * In ra mang so nguyen co so nguyen phan tu lay tu mang so nguyen ban dau bat ky 
	 * Khi nao so do be hon mang so thi moi lam
	 * Su dung for de cho mang moi chay, su dung ham random de lay do dai mang o vi tri bat ky cua mang cu, random haot dong: cho mang tu vi tri 0 den so gioi han tru 1
	 * Sau khi lam xong tra ve mang, neu deu kien dau tra ve mang voi cac gia tri deu la 0
	 */
	public static int[] subArray(int[] arr, int qty) {
		int[] subArray = new int[qty];
		if(qty < arr.length) {
			Random rd = new Random();
			for (int i = 0; i < qty; i++) {
				subArray[i] = arr[rd.nextInt(arr.length)];
			}
			return subArray;
		}
		return subArray;
	}
}
