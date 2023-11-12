package DevideAndConquerApproach;

import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] array) {
		System.out.println("First: " + Arrays.toString(array));
		// 1 3 2 5
		if (array.length <= 1)
			return;
		int pivot = getPivot_MedianOfThree(array);

		int[] arr_left = new int[pivot];
		System.arraycopy(array, 0, arr_left, 0, pivot);

		int[] arr_right = new int[array.length - 1 - pivot];
		System.arraycopy(array, pivot + 1, arr_right, 0, array.length - 1 - pivot);

		quickSort(arr_left);
		quickSort(arr_right);

		System.arraycopy(arr_left, 0, array, 0, pivot);
		System.arraycopy(arr_right, 0, array, pivot + 1, array.length - 1 - pivot);

		System.out.println("Finish: " + Arrays.toString(array));
	}

	private static int getPivot_MedianOfThree(int[] array) {
		int left = array[0];
		int mid = array[(array.length - 1) / 2];
		int right = array[array.length - 1];
		int index_now = 0;
		int pivot = 0;
		if(mid < left && left < right || right < left && left < mid) {
			pivot = left;
			index_now = 0;
		}else if(left < mid && mid < right || right < mid && mid < left){
			pivot = mid;
			index_now = (array.length - 1) / 2;
		}else {
			pivot = right;
			index_now = array.length - 1;
		}
		
		int index = -1;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] < pivot) {
				++index;
				if(array[index] == pivot) 
					index_now = i;

				int temp = array[index];
				array[index] = array[i];
				array[i] = temp;

			}
		}
		
		++index;

		int temp = array[index_now];
		array[index_now] = array[index];
		array[index] = temp;
		return index;
	}

	private static int getPivot_First(int[] array) {
		int pivot = array[0];
		int index = -1;
		int index_position = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < pivot) {
				++index;
				index_position = i;

				int temp = array[index];
				array[index] = array[i];
				array[i] = temp;
			}
		}
		++index;
		int temp = array[index_position];
		array[index_position] = array[index];
		array[index] = temp;

		return index;
	}

	private static int getPivot_Last(int[] array) {
		int high = array.length - 1;
		int pivot = array[high];
		int i = -1; // index of smaller element
		for (int j = 0; j < high; j++) {

			// Nếu phần tử hiện tại nhỏ hơn chốt
			if (array[j] < pivot) {
				i++;

				// swap array[i] và array[j]
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		// swap array[i+1] và array[high] (hoặc pivot)
		++i;

		int temp = array[i];
		array[i] = array[high];
		array[high] = temp;

		return i;
	}

	private static int getPivot_Random(int[] array) {
		int random = (int) (Math.random() * (array.length));
		int pivot = array[random];
		int index = -1;
		int index_now = random;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] < pivot) {
				++index;
				if(array[index] == pivot) 
					index_now = i;

				int temp = array[index];
				array[index] = array[i];
				array[i] = temp;

			}
		}
		
		++index;

		int temp = array[index_now];
		array[index_now] = array[index];
		array[index] = temp;
		return index;
	}

	public static void main(String[] args) {
		int[] arr = { 1,10,2,4,5,7,8,9,3,6 };
		quickSort(arr);
	}
}
