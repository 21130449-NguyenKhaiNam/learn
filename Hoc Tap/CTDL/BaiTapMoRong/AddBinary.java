package LeetCode;

public class AddBinary {
	/*
	 * Cho vao hai chuoi so nhi phan tra ve tong cua chung duoi dang nhi phan Can co
	 * bien chay vi tri cho tung chuoi vi khong biet chuoi nao dai hon do do su dung
	 * while, count la bien nho khi thuc hien viec cong bieu thuc Vd: 1 + 1 nho 1
	 * thi luc do count la 1, it chi la bien luu tam thoi vi khi lay tung vi tri de
	 * vao dieu kien se dai, khi lay ky tu vi da duoc ma hoa nen phai tru di 48 cho
	 * no ve dung con so cua no, 
	 */
	// So lan sai: 4
	public static String addBinary(String a, String b) {
		// Mot cach khac
//		int len1 = a.length();
//		int len2 = b.length();
//		int carry = 0;
//		String res = "";
//		int maxLen = Math.max(len1, len2);
//		for (int i = 0; i < maxLen; i++) {
//		int p = i < len1 ? a.charAt(len1 - 1 - i) - '0' : 0;
//		int q = i < len2 ? b.charAt(len2 - 1 - i) - '0' : 0;
//		int tmp = p + q + carry;
//		carry = tmp / 2;
//		res = tmp % 2 + res;
//		}
//		return (carry == 0) ? res : "1" + res;
		String s = "";
		int ia = a.length() - 1;
		int ib = b.length() - 1;
		int count = 0;
		int it = 0;
		while (Math.min(ia, ib) >= 0) {
			it = a.charAt(ia) + b.charAt(ib) - 2 * 48 + count;
			if (it <= 1) {
				s = it + s;
				count = 0;
			} else if (it == 2) {
				s = "0" + s;
				count = 1;
			} else if (it == 3) {
				s = "1" + s;
				count = 1;
			}
			--ia;
			--ib;
		}
		if (a.length() > b.length()) {
			for (int i = ia; i >= 0; --i) {
				if (a.charAt(i) - 48 + count == 2) {
					s = "0" + s;
					count = 1;
				} else {
					s = a.charAt(i) - 48 + count + s;
					count = 0;
				}
			}
		} else {
			for (int i = ib; i >= 0; --i) {
				if (b.charAt(i) - 48 + count == 2) {
					s = "0" + s;
					count = 1;
				} else {
					s = b.charAt(i) - 48 + count + s;
					count = 0;
				}
			}
		}
		if (count == 1) {
			s = "1" + s;
		}
		return s;

	}

	public static void main(String[] args) {
		System.out.println(addBinary("101111", "10")); // 110001
	}
}
