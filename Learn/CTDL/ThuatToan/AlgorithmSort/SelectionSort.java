package AlgorithmSort;

import java.util.Arrays;

public class SelectionSort {
	/**
	 * Bước 1: Chọn phần tử có khóa nhỏ nhất trong n phần tử từ a[0] đến a[n-1] và
	 * hoán vị nó với phần tử a[0]. Bước 2: Chọn phần tử có khóa nhỏ nhất trong n –
	 * 1 phần tử từ a[1] đến a[n-1] và hoán vị nó với a[1]. Tổng quát ở bước thứ i
	 * chọn phần tử có khóa nhỏ nhất trong n – i phần tử từ a[i] đến a[n-1] và hoán
	 * vị nó với a[i].
	 * 
	 * @param array
	 * @return
	 */

	private int[] sort(int[] array) {
		int[] arr = array.clone();
		int len = arr.length;

		// Duyệt qua từng phần tử của mảng
		for (int i = 0; i < len - 1; i++) {

			// Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
			int min_idx = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[min_idx])
					min_idx = j;
			}
			// Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		SelectionSort SelectionSort = new SelectionSort();
		int[] array = { 1, 3, 4, 8, 9, 1 };
		System.out.println(Arrays.toString(SelectionSort.sort(array)));
	}
}
