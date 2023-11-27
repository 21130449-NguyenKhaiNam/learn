package BasicSorting;

import java.util.Arrays;

public class InsertionSort {

	public static void iterativeInsertionSort(int[] array) {
		System.out.println(Arrays.toString(insertionSort(array)));
	}

	private static int[] insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int index = i;
			for (int j = i - 1; j >= 0; --j) {
				if (array[j] < temp)
					break;
				array[index--] = array[j];
			}
			array[index] = temp;
		}
		return array;
	}

	public static void recursiveInsertionSort(int[] array) {
		// FR: For recursive
		System.out.println(Arrays.toString(insertionSort_FR(array, 1)));
	}

	private static int[] insertionSort_FR(int[] array, int start) {
		if (start >= array.length)
			return array;
		int temp = array[start];
		int index = sort_FR(array, temp, start, start - 1);
		array[index] = temp;
		return insertionSort_FR(array, ++start);
	}

	private static int sort_FR(int[] array, int temp, int index, int start) {
		if (start < 0)
			return index;
		if (array[start] < temp)
			return index;
		array[index--] = array[start];
		return sort_FR(array, temp, index, --start);
	}

	public static void main(String[] args) {
		int[] array = { 32, 43, 14, 36, 38, 20, 34 };
		recursiveInsertionSort(array);
	}
}
