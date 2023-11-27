package LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	public static List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return new ArrayList<>();
		List<String> re = new ArrayList<>();
		String[] str = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		int num = Integer.valueOf(digits);
		while (num != 0) {
			convert(str[(num % 10) - 2], re);
			num /= 10;
		}
		return re;
	}

	private static void convert(String string, List<String> re) {
		// TODO Auto-generated method stub
		if (re.size() == 0) {
			for (char ch : string.toCharArray())
				re.add(ch + "");
		} else {
			int count = re.get(0).length();
			int len = re.size();
			for (char ch : string.toCharArray())
				for (int j = 0; j < len; j++)
					re.add(ch + re.get(j));

			Iterator<String> itr = re.iterator();
			while (itr.hasNext()) {
				if (itr.next().length() == count) {
					itr.remove();
				} else {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("23456").toString());
	}
}
