package LeetCode;

public class ValidPalindrome {
	/*
	 * Kiem tra mot chuoi co phai kieu chu palindrome
	 */
    public static boolean isPalindrome(String s) {
    	s = s.replaceAll("[\\p{P}\\p{S}\\s]", "");
    	String s2 = "";
    	for (int i = s.length()-1; i >= 0; i--) {
			s2 += s.charAt(i);
		}
    	return s.equalsIgnoreCase(s2);
    }
	
    //So lan sai: 0
	public static void main(String[] args) {
		String s = "race a car";
		System.out.println(isPalindrome(s));
	}
}
