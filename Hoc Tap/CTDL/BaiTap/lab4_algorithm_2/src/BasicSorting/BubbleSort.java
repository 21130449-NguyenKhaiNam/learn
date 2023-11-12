package BasicSorting;

import java.util.Arrays;

public class BubbleSort {
	public static void iterativeBubbleSort(int[] array) {
		// TODO
		System.out.println(Arrays.toString(bubbleSort(array)));
	}

	private static int[] bubbleSort(int[] array) {
		// TODO Auto-generated method stub
		if (array.length > 1) {
			boolean bl = true;
			int count = 0;
			while (bl) {
				bl = false;
				for (int j = 0; j < array.length - 1 - count; j++) {
					if (array[j] > array[j + 1]) {
						int temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
						bl = true;
					}
				}
				if (!bl)
					break;
				++count;
			}
		}
		return array;
	}

	// sort by ascending order
	public static void recursiveBubbleSort(int[] array) {
		// FR: For recursive
		System.out.println(Arrays.toString(bubbleSort_FR(array, 0)));
	}

	
	private static int[] bubbleSort_FR(int[] array, int index) {
		// TODO Auto-generated method stub
		if (index >= array.length - 1)
			return array;
		return sort_FR(array, index, 0);
	}

	private static int[] sort_FR(int[] array, int count, int index) {
		// TODO Auto-generated method stub
		if (index >= array.length - count - 1)
			return bubbleSort_FR(array, ++count);
		if (array[index] > array[index + 1]) {
			// swap array[index] và array[index+1]
			int temp = array[index];
			array[index] = array[index + 1];
			array[index + 1] = temp;
		}
		return sort_FR(array, count, ++index);
	}

	public static void main(String[] args) {
		int[] array = { 2,7,8,9,1,10 };
		BubbleSort.iterativeBubbleSort(array);
	}
}
