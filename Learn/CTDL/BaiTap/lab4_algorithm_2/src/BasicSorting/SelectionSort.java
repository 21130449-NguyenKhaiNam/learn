package BasicSorting;

import java.util.Arrays;

public class SelectionSort {
	public static void iterativeSelectionSort(int[] array) {
		// TODO
		System.out.println(Arrays.toString(selectionSort(array)));
	}

	private static int[] selectionSort(int[] array) {
		// TODO Auto-generated method stub
		for (int i = 0; i < array.length - 1; i++) {
			int index = minArray(array, i + 1);
			if (array[i] > array[index]) {
				int temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
		}
		return array;
	}

	private static int minArray(int[] array, int start) {
		int min = array[start];
		int index = start;
		for (int i = start + 1; i < array.length; i++) {
			int temp = array[i];
			if (temp < min) {
				min = temp;
				index = i;
			}
		}
		return index;
	}

	// sort by ascending order
	public static void recursiveSelectionSort(int[] array) {
		// TODO
		//FR: For recursive
		System.out.println(Arrays.toString(selectionSort_FR(array, 0)));
	}

	private static int[] selectionSort_FR(int[] array, int index) {
		// TODO Auto-generated method stub
		if(index >= array.length - 1)
			return array;
//		FR: For recursive
		int index_FR = index + 1;
		int index_min = minArray_FR(array, index_FR, index_FR, array[index_FR]);
		if (array[index] > array[index_min]) {
			int temp = array[index];
			array[index] = array[index_min];
			array[index_min] = temp;
		}
		return selectionSort_FR(array, ++index);
	}

	private static int minArray_FR(int[] array, int start, int index, int minValue) {
		// TODO Auto-generated method stub
		if(start >= array.length)
			return index;
		int temp = array[start];
		if (temp < minValue) {
			minValue = temp;
			index = start;
		}
		return minArray_FR(array, ++start, index, minValue);
	}

	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 6, 10, 9, 3, 7 };
		SelectionSort.recursiveSelectionSort(array);
	}

}
