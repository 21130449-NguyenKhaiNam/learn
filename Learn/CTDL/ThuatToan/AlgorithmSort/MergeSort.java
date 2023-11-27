package AlgorithmSort;

import java.util.Arrays;

public class MergeSort {

	/**
	 * Mảng ban đầu được lặp lại hành động chia cho tới khi kích thước các mảng sau
	 * chia là 1. Khi kích thước các mảng con là 1, tiến trình gộp sẽ bắt đầu. Thực
	 * hiện gộp lại các mảng này cho tới khi hoàn thành và chỉ còn một mảng đã sắp
	 * xếp.
	 * 
	 * @param array
	 * @return
	 */
	// Merge hai mảng con của arr[].
	// Mảng con thứ nhất là arr[l..m]
	// Mảng con thứ hai là arr[m+1..r]
	private void merge(int arr[], int l, int m, int r) {

		// Tìm kích thước của 2 mảng con để merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Tạo mảng tạm
		int L[] = new int[n1];
		int R[] = new int[n2];

		// Copy dữ liệu vào mảng tạm
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		// Merge các mảng tạm lại

		// Chỉ mục ban đầu của 2 mảng con
		int i = 0, j = 0;

		// Chỉ mục ban đầu của mảng phụ được hợp nhất
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Sao chép các phần tử còn lại của L[] nếu có
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// Sao chép các phần tử còn lại của R[] nếu có
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	private int[] sort(int array[], int l, int r) {
		int[] arr = array.clone();
		if (l < r) {
			// Tìm điểm chính giữa
			int m = (l + r) / 2;

			// Hàm đệ quy tiếp tục chia đôi
			arr = sort(arr, l, m);
			arr = sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
		return arr;
	}

	public static void main(String[] args) {
		MergeSort MergeSort = new MergeSort();
		int[] array = { 10, 1, 3, 2, 5, 4, 7, 8, 9, 6 };
		System.out.println(Arrays.toString(MergeSort.sort(array, 0, array.length - 1)));
	}
}
