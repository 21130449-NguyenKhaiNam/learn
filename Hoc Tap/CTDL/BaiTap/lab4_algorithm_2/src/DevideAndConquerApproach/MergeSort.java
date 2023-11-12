package DevideAndConquerApproach;

import java.util.Arrays;

public class MergeSort {
	public static void mergeSort(int[] array) {
		System.out.println(Arrays.toString(mergeSort(array, 0, array.length - 1)));
	}

	private static int[] mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
		return array;
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int len_left = mid - left + 1;
		int len_right = right - mid;

		int[] arr_left = new int[len_left];
		int[] arr_right = new int[len_right];

		for (int i = 0; i < len_left; i++)
			arr_left[i] = arr[left + i];
		for (int i = 0; i < len_right; i++)
			arr_right[i] = arr[mid + i + 1];

		int index_left = 0;
		int index_right = 0;
		int index = left;

		while (index_left < len_left && index_right < len_right) {
			if (arr_left[index_left] < arr_right[index_right]) {
				arr[index] = arr_left[index_left];
				++index_left;
			} else {
				arr[index] = arr_right[index_right];
				++index_right;
			}
			++index;
		}

		while (index_left < len_left) {
			arr[index] = arr_left[index_left];
			++index_left;
			++index;
		}

		while (index_right < len_right) {
			arr[index] = arr_right[index_right];
			++index_right;
			++index;
		}
	}

	public static void main(String[] args) {
		int[] array = { 10, 9, 6, 1, 7, 8 };
		mergeSort(array);
	}

}
