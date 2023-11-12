package LeetCode;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	/*
	 * Tra ve cac so tai vi tri dong do cua tam giac pascal Tao ra tam giac pascal
	 * voi do dai la rowIndex + 1, thuc hien luu tung vi tri tai rowIndex vao getRow
	 */
	// So lan sai: 0
	public List<Integer> getRow(int rowIndex) {
		List<Integer> getRow = new ArrayList<Integer>();
		int[][] pascal = new int[rowIndex + 1][];
		for (int i = 0; i < pascal.length; i++) {
			pascal[i] = new int[i + 1];
			for (int j = 0; j < pascal[i].length; j++) {
				if (j == 0 || j == i) {
					pascal[i][j] = 1;
				} else {
					pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
				}
			}
		}
		for (int i = 0; i < pascal[rowIndex].length; i++) {
			getRow.add(pascal[rowIndex][i]);
		}
		return getRow;
	}

	public static void main(String[] args) {
		PascalsTriangleII pas2 = new PascalsTriangleII();
		System.out.println(pas2.getRow(1).toString());
	}
}
