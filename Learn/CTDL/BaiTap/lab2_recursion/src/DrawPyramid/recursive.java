package DrawPyramid;

public class recursive {
	public static void drawPyramid(int n) {
		for (int i = 0; i < n; i++) {
			for (int k = n - i - 1; k > 0; --k) {
				System.out.print(" ");
			}
			System.out.println(veChuX(i));
		}
	}

	public static String veChuX(int i) {
		if (i == 0)
			return "X";
		return "X " + veChuX(i - 1);
	}

	public static void main(String[] args) {
		drawPyramid(10);
	}
}
