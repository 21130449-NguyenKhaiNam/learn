package BaiTap17;


public class ClassTestNumber {
	/*
	 * Bai tap ve ma tran: tam giac ,cong ,nhan 
	 */
	
	/*
	 * Phai ma tran binh thuong khong
	 * Kiem tra cac cot co bang nhau khong
	 * Toi khi toi gioi han ma tran ma cac cot van bang nhau thi tra ve true (ma tran thong thuong), tra ve false khi la ma tran rang cua
	 */
	public static boolean normalMatrix(double[][] arr) {
		if(arr.length >= 1) {
			for (int i = 0; i < arr.length-1; ) {
				if(arr[i].length == arr[++i].length) {
					if(i == arr.length -1) {
						return true;
					}
				}else {
					break;
				}
			}
		}
		return false;
	}
	/*
	 * In ra ma tran
	 */
	public static void printMatrix(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	/*
	 * Ma tran tam giac
	 */
	public static void triangleMatrix(double[][] arr) {
		if(normalMatrix(arr)) {
			if(arr.length == arr[0].length) {
				int cot = 0;
				int cotTam = 0;
				int dong = 0;
				int count = 0;
				double tinhToan = 0;
				for (int i = 0; i < arr.length && !testTriangleMatrix(arr); i++) {
					cotTam = cot;
					if(arr[i][cot] != 0) {
						++count;
						if(count == 1) {
							dong = i;
							continue;
						}else if(count == 2) {
							tinhToan = arr[i][cot]/arr[dong][cot];
							for (; cot < arr[dong].length; cot++) {
								arr[i][cot] -= arr[dong][cot]*tinhToan;
							}
							cot = cotTam;
							i = -1;
							count = 0;
						}
					}else if(i == arr.length-1) {
						i = -1;
						++cot;
					}
				}
				printMatrix(arr);
			}
		}
	}
	/*
	 * Kiem tra phai ma tran tam giac khong
	 */
	public static boolean testTriangleMatrix(double[][] arr) {
		kiemMaTranTamGiac:
			for (int i = 1; i < arr.length; i++) {
				for (int j = 0; j < i; j++) {
						if(arr[i][j] != 0) {
							break kiemMaTranTamGiac;
						}
				}
				if(i == arr.length - 1) {
					return true;
				}
			}
		return false;
	}
	/*
	 * Kiem ma tran co cung cap
	 * Cung cap khi ca hai deu la ma tran vuong co so dong va cot bang nhau
	 */
	public static boolean sameLevel(double[][] arr1, double[][] arr2) {
		int zero = 0;
		if(arr1.length == arr2.length && normalMatrix(arr1) && normalMatrix(arr2) && arr1[zero].length == arr2[zero].length) {
			return true;
		}
		return false;
	}
	
	/*
	 * Cong ma tran
	 * Cung cap moi cong duoc
	 */
	public static void sumArray(double[][] arr1, double[][] arr2) {
		if(sameLevel(arr1, arr2)) {
			double[][] temp = new double[arr1.length][arr1[0].length];
			for (int i = 0; i < arr1.length; i++) {
				for (int j = 0; j < arr1[i].length; j++) {
					temp[i][j] = arr1[i][j] + arr2[i][j];
				}
			}
			System.out.println("Sum matrix is ");
			printMatrix(temp);
		}else {
			System.out.println("Arr1 not equal Arr2");
		}
	}
	/*
	 * Nhan ma tran
	 * Deu phai la ma tran thong thuong, hai ma tran han duoc khi so cot nay bang so cot kia
	 * Th1: cot arr1 bang dong arr2
	 * Th2: cot arr2 bang dong arr1
	 * ba vong for:
	 *  thuc hien tinh theo tung dong cot, bien k la bien chay vi mot ma tran chay theo cot, mot ma tran chay theo dong ma no deu bang nhau va deu chay het
	 */
	public static void matrixMultiplication(double[][] arr1, double[][] arr2) {
		if(normalMatrix(arr1) && normalMatrix(arr2)) {
			int zero = 0;
			double[][] temp;
			if(arr1[zero].length == arr2.length) {
				temp = new double[arr1.length][arr2[zero].length];
				for (int i = 0; i < temp.length; i++) {
					for (int j = 0; j < temp[zero].length; j++) {
						for (int k = 0; k < arr2.length; k++) {
							temp[i][j] += arr1[i][k]*arr2[k][j];
						}
					}
				}
				System.out.println("Matrix multiplication");
				printMatrix(temp);
			}else {
				System.out.println("Don't matrix multiplication");
			}
		}
	}
}


















