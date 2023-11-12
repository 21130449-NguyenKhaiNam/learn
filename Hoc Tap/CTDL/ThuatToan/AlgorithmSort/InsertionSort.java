package AlgorithmSort;

import java.util.Arrays;

public class InsertionSort {
	/**
	 * 1: Lặp lại từ arr[1] đến arr[n] trên mảng.
	 * 
	 * 2: So sánh phần tử hiện tại (khóa) với phần tử trước của nó.
	 * 
	 * 3: Nếu phần tử chính nhỏ hơn phần tử trước của nó, hãy so sánh nó với các
	 * phần tử trước đó. Di chuyển các phần tử lớn hơn lên một vị trí để tạo khoảng
	 * trống cho phần tử được hoán đổi.
	 */
	private int[] sort(int[] array) {
		int[] arr = array.clone();
		int len = arr.length;
		for (int i = 1; i < len; ++i) {
			int key = arr[i];
			int j = i - 1;

			// Di chuyển các phần tử của arr [0 ... i - 1], lớn hơn key
			// đến một vị trí trước vị trí hiện tại của chúng
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return arr;
	}


	public static void main(String[] args) {
		InsertionSort InsertionSort = new InsertionSort();
		int[] array = { 1, 5, 6, 3, 9, 8, 7, 4, 2 };
		System.out.println(Arrays.toString(InsertionSort.sort(array)));
	}
}
