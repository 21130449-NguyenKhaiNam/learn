package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	/*
	 * Chuoi con dai nhat ma khong co ky tu lap lai
	 */
	public static int lengthOfLongestSubstring(String s) {
		if (s.equals(""))
			return 0;
		Set<String> set = new HashSet<String>();
		int count = 1;
		set.add(s.charAt(0) + "");
		for (int i = 1; i < s.length(); i++) {
			if (!set.add(s.charAt(i) + "")) {
				return Math.max(lengthOfLongestSubstring(s.substring(1, s.length())), count);
			}
			++count;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}
