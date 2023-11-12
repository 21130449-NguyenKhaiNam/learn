package LeetCode;

public class IntegertoRoman {
	/*
	 * Chuyen so ve kieu la ma: I 1 V 5 X 10 L 50 C 100 D 500 M 1000
	 */
	public static String intToRoman(int num) {
		String result = "";
		int[] number = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
		String[] roman = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
		int index = 0;
		while (num != 0) {
			if (num == number[index]) {
				result += roman[index];
				break;
			}
			if (num < number[index] || index == number.length - 1) {
				if (num < number[index])
					--index;
				result += roman[index];
				num -= number[index];
				index = 0;
				continue;
			}
			++index;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(intToRoman((1994)));
	}
}
