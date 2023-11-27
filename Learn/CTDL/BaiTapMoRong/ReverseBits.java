package LeetCode;

public class ReverseBits {
	/*
	 * Cho vao mot so 32 bit, chuyen so do qua dang bit roi thuc hien viec dao,
	 * khong can quan tam dau
	 */

	/*
	 * Mot cach int res = 0; for(int i=0;i<32;i++){ int bit = (n >> i) & 1; res =
	 * res + (bit<<(31-i)); } return res;
	 */
	public static int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int bit = (n >> i) & 1;
			res = res + (bit << (31 - i));
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(reverseBits(-3));
	}
}
