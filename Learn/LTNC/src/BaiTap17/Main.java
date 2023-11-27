package BaiTap17;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] arr1 = {{1,5},{1,6},{2,7}};
		double[][] arr2 = {{2,3,5},{6,2,3}};
		double[][] arr3 = {{1,2,3,5},{7,5,6,1},{1,4,5,7},{4,0,7,3}};
//		ClassTestNumber.printMatrix(arr1);
//		System.out.println();
//		ClassTestNumber.printMatrix(arr2);
//		ClassTestNumber.sumArray(arr1, arr2);
//		ClassTestNumber.matrixMultiplication(arr1, arr2);
		ClassTestNumber.printMatrix(arr3);
		System.out.println();
		ClassTestNumber.triangleMatrix(arr3);
		System.out.println("Chi tim duoc ma tran tam giac tren");
	}
}
