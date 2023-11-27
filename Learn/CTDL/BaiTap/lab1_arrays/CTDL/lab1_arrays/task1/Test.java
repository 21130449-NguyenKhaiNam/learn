package lab1_arrays.task1;

public class Test {
	public static boolean seachFirst() {
		boolean result = false;
		int[] array = { 10, 5, 9, 3, 8, 5, 8, 5 };
		int matchValue = 8;
		for (int i = 0; i < array.length; i++) {
			if (matchValue == array[i]) {
				System.out.println(i);
				result = true;
			}
		}
		return result;
	}

	
	public static void main(String[] args) {
		seachFirst();
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		MyArray myArr = new MyArray(array);
//		myArr.
		System.out.println("ABC");
	}
}
