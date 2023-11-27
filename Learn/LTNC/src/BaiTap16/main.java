package BaiTap16;

import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassTestNumber number = new ClassTestNumber();
		int[] arr = { 1, 8, 7, 4, 8, 2, 0 };
		number.giaTriLonNhatNhoNhat(arr, false);
		number.giaTriLonNhatNhoNhat(arr, true);
		number.tongGiaTriLonNhat(arr);
		number.viTriCoPhanTuLonNhatDauTien(arr);
	}
}
