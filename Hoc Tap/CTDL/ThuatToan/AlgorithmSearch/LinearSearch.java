package AlgorithmSearch;

public class LinearSearch {
	/*
	 * Tim kiem tu dau toi cuoi
	 */
	public int linearSearch(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if(array[i] == target)
				return i;
		}
		
		//Khong tim thay
		return -1;
	}
}
