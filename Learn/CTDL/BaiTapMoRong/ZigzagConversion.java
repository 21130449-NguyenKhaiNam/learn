package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
	public static String convert(String s, int numRows) {
		if (numRows == 1 || numRows > s.length())
			return s;

		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < numRows; i++)
			rows.add(new StringBuilder());

		int curRow = 0;
		boolean goingDown = false;

		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1)
				goingDown = !goingDown;
			curRow += goingDown ? 1 : -1;
		}

		StringBuilder ret = new StringBuilder();
		for (StringBuilder row : rows)
			ret.append(row);
		return ret.toString();
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}
}
