package BaiTap6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassTestNumber number = new ClassTestNumber();
		int[][] matrix = new int[2][4];
		//In ma tran tuy y
		number.printMatrix(matrix);
		
		/*
		 * Ngan cach voi cac cau khac
		 */
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}
		System.out.println();
		
		//In tam giac
		number.createPascalTriangle(5);
		
		/*
		 * Ngan cach voi cac cau khac
		 */
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}
		System.out.println();
		
		//In tam giac theo yeu cau
		int[] diagonalValues = {1, 5, 2, 0};
		System.out.println("Matrix is:");
		for (int i = 0; i < diagonalValues.length; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(number.createPascalTriangle(diagonalValues)[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
