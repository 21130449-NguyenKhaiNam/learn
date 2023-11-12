package AlgorithmSort;

import java.util.Arrays;

public class BubbleSort {
	/**
	 * So sanh hai phan tu lien ke nhau voi mot dieu kien nhat dinh, neu khong thoa
	 * dieu kien thi doi vi tri cho nhau. Quy tac lam: Mac dinh ban dau se kiem tra
	 * voi n - 1 (n la do dai mang) lan, no se so sanh hai vi tri lien ke nhau neu
	 * khong thoa dieu kien dat ra thi doi cho vd: so sanh tai 0 va 1, roi 1 va 2,
	 * roi 2 va 3,...
	 */
	public int[] sort(int[] array) {
		int[] arr = array.clone();
		int len = arr.length;
		boolean check = false;
		for (int i = 0; i < len - 1; i++) {
			check = false;
			for (int j = 0; j < len - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					check = true;
				}
			}
			if (!check)
				break;
		}
		return arr;
	}

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int[] array = { 1, 3, 4, 8, 9, 1 };
		System.out.println(Arrays.toString(bubbleSort.sort(array)));
	}
}
