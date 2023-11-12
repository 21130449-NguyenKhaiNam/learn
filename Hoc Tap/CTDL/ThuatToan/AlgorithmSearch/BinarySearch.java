package AlgorithmSearch;

public class BinarySearch {
	/*
	 * Tim theo kieu chia doi
	 */
	public static int binarySearch(int[] array, int target, int left, int mid, int right) {
		if (left > right)
			return -1;
		if (array[mid] == target)
			return mid;
		int checkLeft = binarySearch(array, target, left, (left + mid - 1) / 2, mid - 1);
		int checkRight = binarySearch(array, target, mid + 1, (mid + 1 + right) / 2, right);
		if (checkLeft != -1)
			return checkLeft;
		return checkRight;
	}

	public static void main(String[] args) {
		int[] array = { 9, 1, 5, 6, 7, 3, 4 };
		System.out.println(binarySearch(array, 3, 0, (array.length - 1) / 2, array.length - 1));
	}
}
