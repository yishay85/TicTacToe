package tictactoe;

/**
 * @author Yishay
 * 
 *         This class is in charge of the game board
 */
enum Mark {
	BLANK, X, O
}

enum Winner {
	DRAW, X_WIN, O_WIN, IN_PROGRESS
}

public class Board {
	public static final int SIZE = 3;
	public static final int WIN_STREAK = 2;

	private Mark[][] board = new Mark[SIZE][SIZE];
	private int countBlankMark;
	private Winner winner;

	public Board() {
		for (int row = 0; row < board.length; row++)
			for (int cal = 0; cal < board.length; cal++)
				this.board[row][cal] = Mark.BLANK;
		this.countBlankMark = 0;
		this.winner = Winner.IN_PROGRESS;
	}

	/**
	 * Put a mark in the required place
	 * 
	 * @param mark The player's sign (X or O)
	 * @param row  The position of the row on the board
	 * @param col  The position of the column on the board
	 * @return True if the transaction completed successfully
	 */
	public boolean putMark(Mark mark, int row, int col) {
		if (!checkingValidLocation(row, col)) {
			System.err.println("The location you selected is out of range,\n  try again.\n");
			return false;
		}
		if (this.board[row][col] != Mark.BLANK) {
			System.err.println("The location you selected is occupied,\n  try again.\n");
			return false;
		}

		this.board[row][col] = mark;
		countBlankMark += 1;
		checkingForWinner(row, col, mark);

		return true;
	}

	/**
	 * Checks if the position in the board is available
	 * 
	 * @param row The position of the row on the board
	 * @param col The position of the column on the board
	 * @return True if the position is blank
	 */
	public Mark getMark(int row, int col) {
		if (!checkingValidLocation(row, col))
			throw new Error("The coordinates are out of range");
		return this.board[row][col];
	}

	/**
	 * Check if the game is over.
	 * 
	 * @return True if the game is over
	 */
	public boolean isGameEnded() {
		if (winner != Winner.IN_PROGRESS || checkingForDraw())
			return true;
		return false;
	}

	/**
	 * 
	 * @return status game (DRAW, X WIN, O WIN, IN PROGRESS)
	 */
	public Winner GameStatus() {
		return winner;
	}

	/**
	 * checking if the location is valid
	 * 
	 * @param row The position of the row on the board
	 * @param col The position of the column on the board
	 * @return True if valid
	 */
	private boolean checkingValidLocation(int row, int col) {
		return (row < SIZE && row >= 0) && (col < SIZE && col >= 0);
	}

	/**
	 * Checks if the game ends in a draw
	 * 
	 * @return True if its draw
	 */
	private boolean checkingForDraw() {
		if (countBlankMark == SIZE * SIZE) {
			winner = Winner.DRAW;
			return true;
		}
		return false;
	}

	/**
	 * Checks if the game ended in victory
	 * 
	 * @param row  The position of the row on the board
	 * @param col  The position of the column on the board
	 * @param mark The player's sign (X or O)
	 * @return True if the game end whit victory
	 */
	private boolean checkingForWinner(int row, int col, Mark mark) {
		boolean flag = true;
		for (int i = 0; i < board.length && flag; i++)
			if (board[i][col] != mark)
				flag = false;

		if (!flag) {
			flag = true;
			for (int i = 0; i < board.length && flag; i++)
				if (board[row][i] != mark)
					flag = false;
		}
		if (!flag && col == row) {
			flag = true;
			for (int i = 0; i < board.length && flag; i++)
				if (board[i][i] != mark)
					flag = false;
		}
		if (!flag && col + row == board.length - 1) {
			flag = true;
			for (int i = 0; i < board.length && flag; i++)
				for (int j = 0; j < board[i].length && flag; j++)
					if (i + j == board.length - 1 && board[i][j] != mark)
						flag = false;
		}
		if (flag) {
			if (mark == Mark.X)
				winner = Winner.X_WIN;
			else
				winner = Winner.O_WIN;
		}
		return flag;
	}

}
