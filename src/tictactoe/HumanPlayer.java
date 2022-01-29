package tictactoe;

public class HumanPlayer implements Player {
	private int countWin;

	public HumanPlayer() {
		this.countWin = 0;
	}

	public void playTurn(Mark mark, Board board) {
		int row, col;
		do {
			System.out.println("Player" + mark + " turn: enter location: ");
			int loc = Game.scanner.nextInt();
			if (loc < 99) {
				col = (loc % 10) - 1;
				row = (loc / 10 % 10) - 1;
			} else
				col = row = -1;

		} while (!board.putMark(mark, row, col));
	}

	/**
	 * @return the countWin
	 */
	public int getCountWin() {
		return countWin;
	}

	/**
	 * count the winning of the player
	 */
	public void setCountWin() {
		this.countWin++;
	}

}
