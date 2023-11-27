package Basic;

public class Task1_1 {
	//Kiem tra ma tran thong thuong
	public static boolean chechkNormalMatrix(int[][] array) {
		int col = array[0].length;
		for (int i = 1; i < array.length; i++) {
			if(array[i].length != col)
				return false;
		}
		return true;
	}
	
	//So sanh hai ma tran
	public static boolean equalMatrix(int[][] a, int[][] b) {
		if(a.length == b.length) {
			if(a[0].length == b[0].length)
				return true;
		}
		return false;
	}
	
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		if(chechkNormalMatrix(a) && chechkNormalMatrix(b)) {
			if(equalMatrix(a, b)) {
				// Thuc hien cong
				int[][] arr = new int[a.length][a[0].length];
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						arr[i][j] = a[i][j] + b[i][j];
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
		int[][] a = { { 7, 2 }, { 5, 3 } };
		int[][] b = { { 2, 1 }, { 3, 1 } };

		printMatrix(add(a, b));
	}
}
