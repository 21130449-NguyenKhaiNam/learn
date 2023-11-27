package LeetCode;

public class HappyNumber {
	/*
	 * Tim co phai la con so hanh phuc, so hanh phuc la so tong binh phuong cac phan
	 * tu lien tuc lai bang 1
	 */
	public static boolean isHappy(int n) {
		if (n == 1 || n == 7 || n == 10 || n == 100)
			return true;
		if (n > 9) {
			String s = n + "";
			n = 0;
			for (char ch : s.toCharArray()) {
				n += Math.pow(Integer.valueOf(ch + ""), 2);
			}
			return isHappy(n);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(19) + "");
	}
}
