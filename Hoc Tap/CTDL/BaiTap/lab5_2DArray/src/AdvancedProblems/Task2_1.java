package AdvancedProblems;

public class Task2_1 {
	public static final char[] SYMBOL = { 'O', 'X' };

	// Bien kiem tra tai vi tri do no bang x hay o
	public static char check = ' ';

	// Bien dem so luong phan tu giong nhau tren mot dong
	public static int count = 0;

	public static int row = 0;
	public static int col = 0;

	public Task2_1() {
		resest();
	}

	public static void resest() {
		check = ' ';
		row = 0;
		col = 0;
	}

	/*
	 * This method checks all rows and returns true if any of them are marked with
	 * all of a single player's markers. Otherwise, returns false.
	 */
	public static boolean checkRows(char[][] board) {
		while (row < board.length) {
			// Lay ky tu la O hay X
			if (board[row][col] == 'O') {
				check = SYMBOL[0];
			} else if (board[row][col] == 'X') {
				check = SYMBOL[1];
			}

			// Neu la khoang trong thi kiem toi cot ke, khong thi thuc hien
			if (check != ' ') {
				for (int i = col + 1; i < board[row].length; i++) {
					if (board[row][i] == check)
						++count;
					if (count == 2)
						return true;
				}
				++row;
				col = 0;
				count = 0;
				continue;
			}
			if(col == board[row].length - 1) {
				++row;
				col = 0;
			} else {
			++col;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		char[][] ch = { { 'O', 'O', 'X' }, { 'X', 'X', 'X' }, { 'X', 'X', 'O' } };
		System.out.println(checkRows(ch));

	}
}
