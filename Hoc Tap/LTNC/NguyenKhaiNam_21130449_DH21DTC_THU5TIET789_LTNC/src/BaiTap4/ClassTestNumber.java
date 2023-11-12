package BaiTap4;

public class ClassTestNumber {
	/*
	 * Cong hai mang so nguyen bat ky co do dai tuy y
	 * Tao for cho chay voi do dai cua mang dai nhat, khi nao vuot qua do dai mang ngan nhat thi chuyen qua truong hop if
	 * Thong bao mang thua
	 */
	public void arrayPlus(int[] arr1, int[] arr2) {
		for (int i = 0; i < Math.max(arr1.length, arr2.length); i++) {
			if(i >= Math.min(arr1.length, arr2.length)) {
				System.out.println("Number at " + i + " position of arr1 is null");
				System.out.println("Number at " + i + " position of arr2: " + arr2[i]);
				System.out.println("Sum at position " + i + " is: " + arr2[i]);
			}else {
				System.out.println("Number at " + i + " position of arr1: " + arr1[i]);
				System.out.println("Number at " + i + " position of arr2: " + arr2[i]);
				arr2[i] = arr1[i] + arr2[i];
				System.out.println("Sum at position " + i + " is: " + arr2[i]);
			}
 		}
		if(arr1.length > arr2.length) {
			System.out.println("Residual array is arr1");
		}else{
			System.out.println("Residual array is arr2");
		}
	}
}
