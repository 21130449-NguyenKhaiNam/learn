package LeetCode;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	/*
	 * Tra ve tam giac pascal o dang list va luu tru list integer Vi i chay tu 0 nen
	 * neu numRows la 0 thi khong thuc hien, thuc hien viec bo vao list intger thong
	 * qua phuong thuc tamGiacPascal, phuong thuc tam giac pascal bo vao integer
	 * thong qua mang arr, voi mang arr la cac so o vi tri dong thu i + 1 cua tam giac pascal
	 */
	// So lan sai: 0
	// Cach khac
//	 List<List<Integer>> res = new ArrayList<List<Integer>>();
//     List<Integer> row, pre = null;
//     for (int i = 0; i < numRows; ++i) {
//         row = new ArrayList<Integer>();
//         for (int j = 0; j <= i; ++j) {
//             if (j == 0 || j == i) {
//                 row.add(1);
//             } else {
//                 row.add(pre.get(j - 1) + pre.get(j));
//             }
//         }
//             pre = row;
//             res.add(row);
//         }
//     return res;
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> generate = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			generate.add(tamGiacPascal(i + 1));
		}
		return generate;
	}

	public List<Integer> tamGiacPascal(int i) {
		List<Integer> tamGiacPascal = new ArrayList<Integer>();
		int[] arr = pascal(i);
		for (int j = 0; j < i; j++) {
			tamGiacPascal.add(arr[j]);
		}
		return tamGiacPascal;
	}

	public int[] pascal(int i) {
		int[][] pascal = new int[i][];
		int[] arr = new int[i];
		for (int k = 0; k < pascal.length; k++) {
			pascal[k] = new int[k + 1];
			for (int j = 0; j < pascal[k].length; j++) {
				if (j == 0 || j == k) {
					pascal[k][j] = 1;
				} else {
					pascal[k][j] = pascal[k - 1][j - 1] + pascal[k - 1][j];
				}
			}
		}
		for (int j = 0; j < i; j++) {
			arr[j] = pascal[i - 1][j];
		}
		return arr;
	}

	public static void main(String[] args) {
		PascalsTriangle ps = new PascalsTriangle();
		System.out.println(ps.generate(5).toString());
	}
}
