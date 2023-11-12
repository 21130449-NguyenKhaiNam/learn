package BaiTap11;

public class Main {
	public static void main(String[] args) {
		int[] arr = {1,5,7,6,10,9,0};
		int a = 4;
		System.out.print("A new matrix is: ");
		for (int i = 0; i < a; i++) {
			System.out.print(ClassTestNumber.subArray(arr, a)[i] + "\t");
		}
	}
}
