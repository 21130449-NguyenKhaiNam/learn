package LeetCode;

public class ExcelSheetColumnNumber {
	/*
	 * Chuoi chuoi ve dung thu tu cot cua chung A -> 1 B -> 2 C -> 3 ... Z -> 26 AA
	 * -> 27 AB -> 28 ...
	 */

	// So lan sai: 3
	/*
	 * Thuc hien voi hai truong hop tu hai tu tro len va chi co 1 tu neu co hai tu
	 * tro len thi tim khoang cach cua tung tu (phuong thuc khoangCachToiA), tu trai
	 * qua phai, no tuan theo qui luat so mu tang dan 26^n. Tiep tuc kiem tra voi
	 * chuoi tiep theo tru chu cai do ra. Neu chi co mot tu thuc hien viec so voi
	 * khoang cach toi A, chi tang 1 don vi tung lan
	 */
	public static int titleToNumber(String columnTitle) {
		if (columnTitle.length() >= 2) {
			return (int) (khoangCachToiA(columnTitle.charAt(0)) * Math.pow(26, columnTitle.length() - 2)
					+ titleToNumber(columnTitle.substring(1)));
		}
		return columnTitle.charAt(0) == 'A' ? 1 : 1 + titleToNumber((char) (columnTitle.charAt(0) - 1) + "");
	}

	public static int khoangCachToiA(char title) {
		return (int) (title == 'A' ? 26 : 26 + khoangCachToiA((char) (title - 1)));
	}

	/*
	 * Cach khac public int titleToNumber(String columnTitle) { int N =
	 * columnTitle.length(); int exponent = 0, sum = 0;
	 * 
	 * for (int i=N-1; i>=0; i--) sum += getValue(columnTitle.charAt(i)) *
	 * Math.pow(26, exponent++);
	 * 
	 * return sum; }
	 * 
	 * private int getValue(char ch) { return ch - 'A' + 1; }
	 */

	public static void main(String[] args) {
		System.out.println(titleToNumber("ABC")); // 24568

	}
}
