package lab1_arrays.task1;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public static int lapBaoNhieuLanTrongMang(int[] arr, int num) {
		int count = 0;
		for (int i : arr) {
			if (num == i)
				++count;
		}
		return count;
	}

	// Count the number of odd numbers in the array
	public int countOddNumbers() {
		// TODO
		int count = 0;
		for (int i : array) {
			if (i % 2 != 0)
				++count;
		}
		return count;
	}

	// get the index of the second even number in the array return -1 (if not)
	public int indexOfSecondEvenNumber() {
		// TODO
		int index = 0;
		int count = 0;
		for (int i = 0; i < array.length; ++i) {
			if (array[i] % 2 == 0) {
				++count;
				if (count == 2)
					return i;
			}
		}
		return -1;
	}

	// Method mirror that outputs the contents of an array in a reverse //order like
	// a mirror
	// Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]

	public int[] mirror() {
		// TODO
		int[] arr = new int[array.length * 2];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			arr[i] = array[index];
			arr[arr.length - 1 - i] = array[index];
			++index;
		}
		return arr;
	}

	// GET the element which its occurence is the most in the array.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}
	// Output: 10
	public int getMode() {
		// TODO
		int max = array[0];
		for (int i : array) {
			if (lapBaoNhieuLanTrongMang(array, max) < lapBaoNhieuLanTrongMang(array, i))
				max = i;
		}
		return max;
	}

	// GET unique elements in the array.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}
	// Output: 12, 9, 2

	/*
	 * Bien count dung de dem co bao nhieu phan tu khong bi trung lap trong mang,
	 * bang cach chay vong lap voi tinh chat neu co phan tu nao bi trung trong mang
	 * thi bo qua, khong thi tang bien count len 1 don vi. Sau do bien count cung chinh la do dai 
	 */
	public int[] getUniqueElements() {
		// TODO
		int count = 0;
		for (int i : array) {
			if (lapBaoNhieuLanTrongMang(array, i) <= 1)
				++count;
		}
		int[] arr = new int[count];
		count = 0;
		for (int i : array) {
			if (lapBaoNhieuLanTrongMang(array, i) <= 1) {
				arr[count] = i;
				++count;
			}
		}
		return arr;
	}

	// GET distinct elements in the array.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}
	// Output: 12, 10, 9, 45, 2
	public static int kiemCoLapTheoChieuNguocLai(int[] arr, int num, int i) {
		int count = 0;
		for (int j = i - 1; j >= 0; --j) {
			if (arr[j] == num)
				++count;
		}
		return count;
	}

	public int[] getDistinctElements() {
		// TODO
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (kiemCoLapTheoChieuNguocLai(array, array[i], i) == 0)
				++count;
		}
		int[] arr = new int[count];
		count = 0;
		for (int i = 0; i < array.length; i++) {
			if (kiemCoLapTheoChieuNguocLai(array, array[i], i) == 0) {
				arr[count] = array[i];
				++count;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
	}

}
