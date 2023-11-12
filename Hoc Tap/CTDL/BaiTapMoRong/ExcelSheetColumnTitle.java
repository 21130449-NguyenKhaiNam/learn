package LeetCode;

public class ExcelSheetColumnTitle {
	/*
	 * Nhap vao mot so nguyen tra ve bang chu cai tuong ung nhu cot excel VD: A -> 1
	 * B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ...
	 */
	//Coppy code
	public String convertToTitle(int columnNumber) {
		return columnNumber == 0 ? "" :  convertToTitle((columnNumber - 1) / 26) + (char) ('A' + ((columnNumber - 1) % 26));
	}
	
	public static void main(String[] args) {
		ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
		System.out.println(test.convertToTitle(731));
	}
}
