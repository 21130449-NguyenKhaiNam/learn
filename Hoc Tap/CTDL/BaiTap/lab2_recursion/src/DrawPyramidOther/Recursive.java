package DrawPyramidOther;

public class Recursive {
	/*
	 * Tam giác hình chĩa bình thường
	 */
	public static void drawPyramidDown(String shape, int n) {
		for (int i = 0; i < n; i++) {
			for (int k = n - i - 1; k > 0; --k) {
				System.out.print(" ");
			}
			System.out.println(veChuX(shape, i));
		}
	}
	
	public static String veChuX(String shape, int i) {
		if (i == 0)
			return shape;
		return shape + " " + veChuX(shape, i - 1);
	}
	
	/*
	 * Tam giác hình đảo
	 */
	public static void drawPyramidUp(String shape, int n) {
		for (int i = n - 1; i >= 0; --i) {
			for (int k = i + 1; k < n; ++k) {
				System.out.print(" ");
			}
			System.out.println(veChuX(shape, i));
		}
	}

	/*
	 * Tam giác pascal số bắt đầu khác, loại bình thường
	 */
	public static void printPascalTriangleDown(int row, int number) {
		for (int i = 1; i <= row; i++) {
			for (int j = i; j < row; ++j) {
				System.out.print(" ");
			}
			inMaTran(getPascalTriangle(i, number));;
		}
	}
	
	public static void inMaTran(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] getPascalTriangle(int n, int number) {
		if(n == 1) {
			int[] arr = {number};
			return arr;
		}else {
			return generateNextRow(getPascalTriangle(n - 1, number), number);
		}
	}

	public static int[] generateNextRow(int[] prevRow, int number) {
		int[] nextRow = new int[prevRow.length + 1];
		nextRow[0] = number;
		nextRow[nextRow.length - 1] = number;
		for (int i = 1; i < nextRow.length - 1; i++) {
			nextRow[i] = prevRow[i - 1] + prevRow[i];
		}
		return nextRow;
	}
	
	/*
	 * Tam giác pascal số bắt đầu khác, loại đảo
	 */
	public static void printPascalTriangleUp(int row, int number) {
		for (int i = row; i >= 1; --i) {
			for (int j = i; j < row; ++j) {
				System.out.print(" ");
			}
			inMaTran(getPascalTriangle(i, number));;
		}
	}
	
	public static void main(String[] args) {
		drawPyramidDown("*", 5);
		System.out.println("------------------");
		drawPyramidUp("*", 5);
		System.out.println("------------------");
		printPascalTriangleDown(5, 9);
		System.out.println("------------------");
		printPascalTriangleUp(5, 9);
		
	}
}
