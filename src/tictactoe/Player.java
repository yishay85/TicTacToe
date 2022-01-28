package tictactoe;

public class Player {
	private int countWin;

	public Player() {
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
	 * @param countWin the countWin to set
	 */
	public void setCountWin() {
		this.countWin++;
	}

}