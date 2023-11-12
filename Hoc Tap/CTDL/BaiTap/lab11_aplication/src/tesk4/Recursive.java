package tesk4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Recursive {
	// No. 1
	static int maxNum(int[] arr) {
		if (arr.length == 0)
			throw new NullPointerException();
		else
			return maxNumIf(arr, 0, x -> true);
	}

	private static int maxNumIf(int[] arr, int i, Predicate<Integer> pre) {
		// TODO Auto-generated method stub
		return i > arr.length - 1 ? Integer.MIN_VALUE
				: Math.max((pre.test(arr[i]) ? arr[i] : Integer.MIN_VALUE), maxNumIf(arr, ++i, pre));
	}

	static double powWithYPositiveInteger(double x, int y) {
		return y <= 0 ? 1 : x * powWithYPositiveInteger(x, --y);
	}

	static List<Integer> findIndexC(char c, String str) {
		return str.isEmpty() ? null : findIndexC(c, str, new ArrayList<Integer>(), 0);
	}

	private static List<Integer> findIndexC(char c, String str, ArrayList<Integer> arrayList, int i) {
		// TODO Auto-generated method stub
		if (i >= str.length())
			return arrayList;
		if (str.charAt(i) == c)
			arrayList.add(i);
		return findIndexC(c, str, arrayList, ++i);
	}

	static void printOddNumber(int count) {
		printOddNumber(count, 1);
	}

	private static void printOddNumber(int count, int num) {
		// TODO Auto-generated method stub
		if (count <= 0)
			return;
		System.out.print(num + " ");
		printOddNumber(--count, num + 2);

	}

	static int sumOdd(int[] arr) {
		if (arr.length == 0)
			throw new NullPointerException();
		else
			return sumOddIf(arr, 0, arr.length);
	}

	private static int sumOddIf(int[] arr, int i, int k) {
		// TODO Auto-generated method stub
		return i > arr.length - 1 || k == 0 ? 0
				: (arr[i] % 2 == 0 ? 0 : arr[i]) + sumOddIf(arr, ++i, (arr[i - 1] % 2 == 0 ? k : --k));
	}

	static int sumOddIf(int[] arr, int k) {
		if (arr.length == 0)
			throw new NullPointerException();
		else
			return sumOddIf(arr, 0, k);
	}

	static int oddMax(int[] arr) {
		return maxNumIf(arr, 0, x -> (x % 2 != 0));
	}

	public static void main(String[] args) {
		int[] arr = { -1, -3, 2, 12 };
		System.out.println("Cau 1: " + maxNum(arr));
		System.out.println("Cau 2: " + powWithYPositiveInteger(2, 4));
		System.out.println("Cau 3: " + findIndexC('n', "nguyen khai nam"));
		System.out.print("Cau 4: ");
		printOddNumber(10);
		System.out.println();
		System.out.println("Cau 5: " + sumOdd(arr));
		System.out.println("Cau 6: " + sumOddIf(arr, 3));
		System.out.println("Cau 7: " + powWithYPositiveInteger(2, 3));
		System.out.println("Cau 8: " + oddMax(arr));

	}
}
