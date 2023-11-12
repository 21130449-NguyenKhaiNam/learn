package LeetCode;

public class PlusOne {
	/*
	 * Cho vao mang so nguyen, Cong so do len mot don vi roi in ra mang moi voi so
	 * do moi vi tri la mot so be hon 10 Tang so o vi tri cuoi thuc hien kiem tra
	 * neu no la 10 va da het vi tri thi tao mang moi voi vi tri dau la trong neu
	 * khong vuot qua do dai thi thuc hien luu tai vi tri do la 0 va tang vi tri ke
	 * tiep len 1 don vi
	 */
	// So lan sai: 7
	public static int[] plusOne(int[] digits) {
//		Mot cach khac
//		for (int i = digits.length - 1; i >= 0; i--) {
//			if (digits[i] != 9) {
//				digits[i]++;
//				return digits;
//			}
//			digits[i] = 0;
//		}
//		int[] res = new int[digits.length + 1];
//		res[0] = 1;
//		return res;
		digits[digits.length - 1] += 1;
		for (int i = digits.length - 1; i >= 0; --i) {
			if (i == 0 && digits[i] == 10) {
				int[] a = new int[digits.length + 1];
				digits[digits.length - 1] -= 1;
				int count = a.length - 1;
				for (int j = digits.length - 1; j >= 0; --j) {
					a[count--] = digits[j];
				}
				digits = plusOne(a);
			} else if (digits[i] == 10) {
				digits[i] = 0;
				digits[i - 1] += 1;
			}
		}
		return digits;
	}

	public static void inMang(int[] mang) {
		for (int i = 0; i < mang.length; i++) {
			System.out.print(mang[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] digits = { 8, 9 };
		inMang(plusOne(digits));
	}
}
