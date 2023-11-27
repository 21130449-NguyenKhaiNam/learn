package LeetCode;

public class LengthOfLastWord {
	/*
	 * Tra ve do dai cua tu cuoi cung trong chuoi Chuoi chuoi ve mang thuc hien viec
	 * tim kiem tu vi tri cuoi len neu diem cuoi la khoang trang thi bo qua va tim
	 * toi khi gap chu va ket thuc tim khi gap khoang trang
	 */
	// So lan sai: 1
	public static int lengthOfLastWord(String s) {
		// Cach hay hon
//		s = s.trim();
//        if(s.length() <= 1) return s.length(); 
//        s = s.substring(s.lastIndexOf(' ')+1);
//        return s.length();
		char[] tuKhoa = s.toCharArray();
		String tuCuoi = "";
		int count = 0;
		for (int i = tuKhoa.length - 1; i >= 0; i--) {
			if (tuKhoa[i] != ' ') {
				count = i;
				tuCuoi += tuKhoa[i];
			} else if (i < count) {
				break;
			}
		}
		return tuCuoi.length();
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("a;a;a"));
		System.out.println(lengthOfLastWord(" "));
		System.out.println(lengthOfLastWord("Anh ban co duoc em"));
		System.out.println(lengthOfLastWord("Anh ban co duoc em  "));
	}
}
