package Pascal;

public class recursive {
	
	public static void printPascalTriangle(int row) {
		for (int i = 1; i <= row; i++) {
			for (int j = i; j < row; ++j) {
				System.out.print(" ");
			}
			inMaTran(getPascalTriangle(i));;
		}
	}
	
	public static void inMaTran(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] getPascalTriangle(int n) {
		if(n == 1) {
			int[] arr = {1};
			return arr;
		}else {
			return generateNextRow(getPascalTriangle(n - 1));
		}
	}

	public static int[] generateNextRow(int[] prevRow) {
		int[] nextRow = new int[prevRow.length + 1];
		nextRow[0] = 1;
		nextRow[nextRow.length - 1] = 1;
		for (int i = 1; i < nextRow.length - 1; i++) {
			nextRow[i] = prevRow[i - 1] + prevRow[i];
		}
		return nextRow;
	}

	public static void main(String[] args) {
		int n = 10;
		recursive recursive = new recursive();
		recursive.printPascalTriangle(n);
	}
}
