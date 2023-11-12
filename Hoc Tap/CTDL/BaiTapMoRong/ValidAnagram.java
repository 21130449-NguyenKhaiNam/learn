package LeetCode;


public class ValidAnagram {
	/*
	 * Kiem tra xem chuoi t co du chu cai cua chuoi s khong
	 */
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] alphabet_count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			++alphabet_count[s.charAt(i) - 'a'];
			--alphabet_count[t.charAt(i) - 'a'];
		}
		for (int i : alphabet_count) {
			if(i != 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("abcdefghijklmnopqrstwvuxyzaa",
				"abcdefghijklmnopqrstwvuxyzab"));
	}
}
