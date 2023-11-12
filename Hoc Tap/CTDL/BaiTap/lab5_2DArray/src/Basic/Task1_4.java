package Basic;

import java.util.Arrays;

public class Task1_4 {
	//Kiem tra ma tran thong thuong
		public static boolean chechkNormalMatrix(int[][] array) {
			int col = array[0].length;
			for (int i = 1; i < array.length; i++) {
				if(array[i].length != col)
					return false;
			}
			return true;
		}
	
	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		if(chechkNormalMatrix(a)) {
			//Thuc hien
			int[][] arr = new int[a[0].length][a.length];
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = a[j][i];
					//j == 2
				}
			}
			
			return arr;
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,2},{3,4},{5,6}};
		System.out.println(Arrays.deepToString(transpose(a)));
	}
}
