package LeetCode;

public class LongestPalindromicSubstring {
	/*
	 * Co phai la mot chuoi palindromic. Mot chuoi palindromic la mot mot ma dao hay
	 * thuong la giong nhau
	 */
	public static String longestPalindrome(String s) {
		if(s.length() < 2)
			return s;
		int lenMax = Integer.MIN_VALUE;
		int lenS = s.length();
		int left = 0;
		int right = lenS - 1;
		String result = s.charAt(0) + "";
		while (left < lenS - 1) {
			if(s.charAt(left) == s.charAt(right)) {
				String temp = s.substring(left, right + 1);
				if(isPalindrome(temp)) {
					int len = temp.length();
					if(len > lenMax) {
						result = temp;
						lenMax = len;
					}
					++left;
					right = lenS - 1;
					continue;
				}
			}
			--right;
			if(left == right) {
				++left;
				right = lenS - 1;
			}
		}
		return result;
	}

	private static boolean isPalindrome(String str) {
		// TODO Auto-generated method stub
		if(str.length() == 2)
			return str.charAt(0) == str.charAt(1);
		int left = 1;
		int right = str.length() - 2;
		while(left != right) {
			if(right - 1 == left) 
				return str.charAt(left) == str.charAt(right);
			if(str.charAt(left) != str.charAt(right))
				return false;
			++left;
			--right;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("ac"));
	}
}
