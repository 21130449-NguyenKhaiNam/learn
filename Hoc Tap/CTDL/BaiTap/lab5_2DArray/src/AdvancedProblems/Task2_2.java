package AdvancedProblems;

public class Task2_2 {
	/*
	 * This method checks all columns and returns true if any of them are marked
	 * with all of a single player's. Otherwise, returns false.
	 */
	public static boolean checkColumns(char[][] board) {
		char x = 'X';
		char o = 'O';
		int count = 0;
		char ch = '-';
		//Col luon bang row
		for (int i = 0; i < board[0].length; i++) {
			if(board[i][i] == x) {
				ch = x;
			}else if(board[i][i] == o){
				ch = o;
			}
			for (int j = 0; j < board.length; j++) {
				if(board[j][i] == ch) {
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
		char[][] ch = {{'X', 'O', 'X'}, {'X', 'O', 'X'}, {'O', 'X', 'X'}};
		System.out.println(checkColumns(ch));
	}
}
