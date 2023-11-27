package LeetCode;

public class ReverseInteger {
	/*
	 * Dao con so duoc truyen vao
	 */
	public static int reverse(int x) {
		int reverse = 0;
		int count = 0;
		while (x != 0) {
			int temp = reverse;
			reverse = reverse * 10 + x % 10;
			x /= 10;
			if (++count >= 9)
				if (x > 2 || count > 10 || reverse / 10 != temp)
					return 0;
		}
		return reverse;
	}

	public static void main(String[] args) {
		System.out.println(reverse(-2) + "");
	}
}
