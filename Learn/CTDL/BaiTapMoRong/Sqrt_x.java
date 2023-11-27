package LeetCode;

public class Sqrt_x {
	/*
	 * Cho vao so nguyen x tinh ra can x la so nguyen ma khong su dung phuong thuc
	 * ho tro khac
	 */
	// So lan sai: 1
	public static int mySqrt(int x) {
		// Code tren mang
		double a, b;
		a = (double) x / 2;
		b = 0;
		while (a != b) {
			b = a;
			//Bieu thuc truy hoi tim can
			a = (a + x / a) / 2;
		}
		return (int) a;
	}

	public static void main(String[] args) {
		mySqrt(8);
	}
}
