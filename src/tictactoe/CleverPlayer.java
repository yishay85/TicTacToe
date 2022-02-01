package tictactoe;

/**
 * The class serves as a "smart" player who plays automatically with a little
 * more thought
 * 
 * @author Yishay
 *
 */
public class CleverPlayer implements Player {

	private int countWin;

	public CleverPlayer() {
		this.countWin = 0;
	}

	@Override
	public void playTurn(Mark mark, Board board) {
		int index = checkLines(mark, board);
		if (index != -1) {
			for (int i = 0; i < Board.SIZE; i++) {
				if (checkAndPut(mark, board, index, i))
					return;
			}
		}
		index = checkColumns(mark, board);
		if (index != -1) {
			for (int i = 0; i < Board.SIZE; i++) {
				if (checkAndPut(mark, board, i, index))
					return;
			}
		}

		for (int i = 0; i < Board.SIZE; i++) {
			for (int j = 0; j < Board.SIZE; j++) {
				if (checkAndPut(mark, board, i, j))
					return;
			}
		}

	}

	@Override
	public int getCountWin() {
		return countWin;
	}

	@Override
	public void setCountWin() {
		countWin++;
	}

	/**
	 * Put mark on the board
	 * 
	 * @param mark:  The player's sign (X or O)
	 * @param board: The board of the game
	 * @param i:     The position of the row on the board
	 * @param j:     The position of the column on the board
	 * @return True if the transaction completed successfully
	 */
	private boolean checkAndPut(Mark mark, Board board, int i, int j) {
		if (board.getMark(i, j) == Mark.BLANK)
			return board.putMark(mark, i, j);
		return false;
	}

	/**
	 * Looking for a free line to put a mark on
	 * 
	 * @param mark:  The player's sign (X or O)
	 * @param board: The board of the game
	 * @return index of line
	 */
	private int checkLines(Mark mark, Board board) {
		for (int i = 0; i < Board.SIZE; i++) {
			boolean flag = true;
			for (int j = 0; j < Board.SIZE; j++) {
				if (board.getMark(i, j) != mark && board.getMark(i, j) != Mark.BLANK) {
					flag = false;
					break;
				}
			}
			if (flag)
				return i;
		}
		return -1;
	}

	/**
	 * Looking for a free column to put a mark on
	 * 
	 * @param mark:  The player's sign (X or O)
	 * @param board: The board of the game
	 * @return index of column
	 */
	private int checkColumns(Mark mark, Board board) {
		for (int i = 0; i < Board.SIZE; i++) {
			boolean flag = true;
			for (int j = 0; j < Board.SIZE; j++) {
				if (board.getMark(j, i) != mark && board.getMark(j, i) != Mark.BLANK) {
					flag = false;
					break;
				}
			}
			if (flag)
				return i;
		}
		return -1;
	}
}
