package Basic;

import java.util.Iterator;

public class Task1_3 {
	//Kiem tra ma tran thong thuong
		public static boolean chechkNormalMatrix(int[][] array) {
			int col = array[0].length;
			for (int i = 1; i < array.length; i++) {
				if(array[i].length != col)
					return false;
			}
			return true;
		}
	
	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		if(chechkNormalMatrix(a) && chechkNormalMatrix(b)) {
			//Thuc hien nhan hai ma tran
			int col_a = a[0].length;
			int row_b = b.length;
			if (col_a == row_b) {
				int[][] arr = new int[col_a][row_b];

				// Nhan ma tran
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						for (int k = 0; k < arr.length; k++) {
							arr[i][j] += a[i][k] * b[k][j];
						}
					}
				}
				return arr;
			}
		}
		return null;
	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 5, 4, 1 }, { 8, 7, 2 }, { 5, 4, 3 } };
		int[][] b = { { 1, 8, 9 }, { 7, 2, 6 }, { 0, 2, 4 } };
		printMatrix(multiply(a, b));
	}
}
