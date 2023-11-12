package AdvancedProblems;

public class Task2_3 {
	/*
	 * This method checks both diagonals and returns true if any of them are marked
	 * with all of a single player's markers. Otherwise, returns false.
	 */
	public static boolean checkDiagonals(char[][] board) {
		int count = 0;
		int col = 0;
		char x= 'X';
		char o = 'O';
		char ch = '-';
		
		for (int i = 0; i < board.length; i++) {
			if (board[0][i] == x) {
				ch = x;
			} else if (board[0][i] == o) {
				ch = o;
			}
			//Kiem ben trai
			for (int j = i; j >= 0; --j) {
				if(board[j][col] == ch) {
					++count;
					++col;
				}else {
					break;
				}
			}
			
			if(count == 3)
				return true;
			count = 0;
			col = 0;
			
			//Kiem ben phai
			for (int j = i; j < board.length; ++j) {
				if(board[j][j] == ch) {
					++count;
				}else {
					break;
				}
			}
			if(count == 3)
				return true;
			count = 0;
		}
		return false;
	}
	
	public static void main(String[] args) {
		char[][] ch = { { 'O', 'X', 'O' }, { 'X', 'O', 'X' }, { 'O', 'O', 'X' } };
		System.out.println(checkDiagonals(ch));
	}
}
