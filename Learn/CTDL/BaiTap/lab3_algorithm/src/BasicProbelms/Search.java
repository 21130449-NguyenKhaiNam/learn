package BasicProbelms;

public class Search {
	private int[] array;

	public Search(int[] array) {
		this.array = array;
	}

	// To find the index of the target in the array. If the target
	// is not found
	// in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public int iterativeLinearSearch(int target) {
		// TODO
		for (int i = 0; i < array.length; i++) {
			if (target == array[i])
				return i;
		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	// is not found
	// in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public int recursiveLinearSearch(int target) {
		// TODO
		if (array.length == 0)
			return -1;
		if (target == array[0])
			return 0;
		return linearSearch(target, 1);
	}

	private int linearSearch(int target, int i) {
		// TODO Auto-generated method stub
		if (i == array.length)
			return -1;
		return target == array[i] ? i : linearSearch(target, ++i);
	}

	// To find the index of the target in the sorted array. If the target is not
	// found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {
		// TODO
		int left = 0;
		int right = array.length - 1;
		int mid = 0;
		while (left != right) {
			mid = (left + right) / 2;
			int temp = array[mid];
			if (target == temp)
				return mid;
			if (target < temp)
				right = mid - 1;
			if (target > temp)
				left = mid + 1;
		}
		return target == array[mid] ? mid : -1;
	}

	// To find the index of the target in the sorted array. If the target is not
	// found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target) {
		// TODO
		if (array.length == 0)
			return -1;
		return binarySearch(target, 0, array.length - 1);
	}

	private int binarySearch(int target, int left, int right) {
		// TODO Auto-generated method stub
		int mid = (left + right) / 2;
		if(left != right) {
			int temp = array[mid];
			if (target == temp)
				return mid;
			if (target < temp)
				return binarySearch(target, left, mid - 1);
			if (target > temp)
				return binarySearch(target, mid + 1, right);
		}
		return target == array[mid] ? mid : -1;
	}

}
