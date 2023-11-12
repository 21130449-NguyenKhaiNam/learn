package BaiTap4;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassTestNumber number = new ClassTestNumber();
		int[] arr1 = new int[3];
		int[] arr2 = new int[6];
		for (int i = 0; i < arr1.length; i++) {
			Random random = new Random();
			arr1[i] = random.nextInt(100);
		}
		for (int i = 0; i < arr2.length; i++) {
			Random random = new Random();
			arr2[i] = random.nextInt(100);
		}
		number.arrayPlus(arr1, arr2);
		
	}
}
